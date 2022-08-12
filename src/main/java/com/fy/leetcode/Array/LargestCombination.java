package com.fy.leetcode.Array;

import org.junit.Test;

import java.util.Arrays;

/**
 * @Classname LargestCombination
 * @Description TODO
 * @Date 2022/5/15 11:05
 * @Created by fy
 */
public class LargestCombination {
    @Test
    public void test(){
        int[] candidates = {16,17,71,62,12,24,14};
        largestCombination(candidates);
    }
    public int largestCombination(int[] candidates) {
        int len = candidates.length;
        int[][] resarr = new int[len][31];
        int maxsize = 0;
        for(int i = 0; i < len; i++){
            Arrays.fill(resarr[i], 1);
            int count = 0;
            int num = candidates[i];
            while (num > 0){
                resarr[i][count] = resarr[i][count] & (num % 2);
                num = num / 2;
                count++;
            }
            for(int k = count; k < 32; k++){
                resarr[i][k] = 0;
            }
            maxsize = Math.max(maxsize, count);
        }
        int res = 0;
        for(int i = 0; i < maxsize;i++){
            int tmpres = 0;
            for(int j = 0; j < len; j++){
                if(resarr[j][i] == 1){
                    tmpres += 1;
                }
            }
            res = Math.max(res, tmpres);
        }
        return res;
    }
}
