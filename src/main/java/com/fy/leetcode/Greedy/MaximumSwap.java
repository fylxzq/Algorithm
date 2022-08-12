package com.fy.leetcode.Greedy;

/**
 * @Classname MaximumSwap
 * @Description TODO
 * @Date 2022/3/26 18:19
 * @Created by fy
 */
public class MaximumSwap {
    public int maximumSwap(int num) {
        String numStr = String.valueOf(num);
        char[] chars = numStr.toCharArray();
        int[] dp = new int[10];
        for(int i = 0; i < chars.length; i++){
            dp[chars[i] - '0'] = i;
        }
        for(int i = 0; i < chars.length; i++){
            for(int j = 9; j > chars[i] - '0'; j--){
                if(dp[j] > i){
                    swap(i, j, chars);
                    break;
                }
            }
        }
        return Integer.parseInt(new String(chars));
    }

    private void swap(int i,int j,char[] arr){
        char tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
