package com.fy.practice;

import org.junit.Test;

/**
 * @Classname BackPack
 * @Description TODO
 * @Date 2021/1/10 21:05
 * @Created by fy
 */
public class BackPack {

    public void test(){//数据测试
        int C = 8;
        int[] w = {0,2,3,4,5};
        int[] v = {0,3,4,5,6};
        int rst = getmaxValue(8,4,w,v);
    }
    //C代表背包的容量，N代表物品个数，w[i]代表第i个物品的重量，v[i]代表第i个物品的价值
    public int getmaxValue(int C,int N,int[] w,int[] v){
        int[][] dp = new int[N+1][C+1];
        //表示将前i件物品装进限重为j的背包可以获得的最大价值, 0<=i<=N, 0<=j<=W
        for (int i=1;i<=N;++i){
            for(int j=1;j<=C;++j){
                if(w[i]>j){
                    dp[i][j] = dp[i-1][j];
                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i-1][j-w[i]]+v[i]);
                }
            }
        }
        return dp[N][C];
    }
}
