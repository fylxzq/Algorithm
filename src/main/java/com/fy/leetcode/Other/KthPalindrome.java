package com.fy.leetcode.Other;

import java.util.Map;

/**
 * @Classname kthPalindrome
 * @Description TODO
 * @Date 2022/3/27 11:14
 * @Created by fy
 */
public class KthPalindrome {
    public long[] kthPalindrome(int[] queries, int intLength) {
        int len = queries.length;
        int half_len = (intLength + 1) / 2;
        long[] res = new long[len];
        long begin = 1;
        for(int j = 0; j < half_len - 1; ++j){
            begin *= 10;
        }
        long max_num = begin * 10 - begin;
        for(int i = 0; i < len; ++i){
            if(queries[i] > max_num){
                queries[i] = -1;
            }
            else{
                res[i] = queries[i] + begin - 1;
            }
        }
        for(int i = 0; i < res.length; ++i){
            long tmp = res[i];
            if(res[i] == -1){
                continue;
            }
            if(intLength % 2 == 1){
                res[i] /= 10;
            }
            for(int j = 0;j < intLength - half_len; ++j){
                tmp = tmp * 10 + res[i] % 10;
                res[i] /= 10;
            }
            res[i] = tmp;
        }
        return res;
    }
}
