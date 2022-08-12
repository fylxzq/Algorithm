package com.fy.leetcode.Array;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Classname Tencent424ThreeSolider
 * @Description TODO
 * @Date 2022/4/24 20:51
 * @Created by fy
 */
public class Tencent424ThreeSolider {
    public static void main(String[] args) throws IOException {
        int n = 1;
        String s = "1";
        int[] attacks = new int[n];
        int[] defense = new int[n];
        int preSum = 0;
        for(int i = 0; i < n; i++){
            if(s.charAt(i) == '0'){
                preSum += (i + 1);
            }
            attacks[i] = preSum;
        }
        preSum = 0;
        for(int j = n - 1; j >= 0;j --){
            defense[j] = preSum;
            if(s.charAt(j) == '1'){
                preSum += (j + 1);
            }
        }
        int res = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++){
            res = Math.min(res, Math.abs(attacks[i]-defense[i]));
        }
        System.out.println(res);
    }
    public int getRes(int n,String s){
        int[] attacks = new int[n];
        int[] defense = new int[n];
        int preSum = 0;
        for(int i = 0; i < n; i++){
            if(s.charAt(i) == '0'){
                preSum += (i + 1);
            }
            attacks[i] = preSum;
        }
        preSum = 0;
        for(int j = n - 1; j >= 0;j --){
            defense[j] = preSum;
            if(s.charAt(j) == '1'){
                preSum += (j + 1);
            }
        }
        int res = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++){
            res = Math.min(res, Math.abs(attacks[i]-defense[i]));
        }
        return res;
    }
}
