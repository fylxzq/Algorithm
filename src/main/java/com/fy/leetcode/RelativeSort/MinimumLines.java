package com.fy.leetcode.RelativeSort;

import java.util.Arrays;

/**
 * @Classname MinimumLines
 * @Description TODO
 * @Date 2022/5/22 10:57
 * @Created by fy
 */
public class MinimumLines {
    public int minimumLines(int[][] stockPrices) {
        int len = stockPrices.length;
        if(len == 1 || len == 2){
            return len - 1;
        }
        Arrays.sort(stockPrices, (e1 , e2) -> {
           return e1[0] - e2[0];
        });
        long preMolecular = stockPrices[1][1] - stockPrices[0][1];//前一个分子
        long preMenominator = stockPrices[1][0] - stockPrices[0][0];//前一个分母
        int res = 1;
        for(int i = 2; i < len; i++){
            long curMolecular = stockPrices[i][1] - stockPrices[i - 1][1];
            long curMenominator = stockPrices[i][0] - stockPrices[i - 1][0];
            if(preMolecular * curMenominator != preMenominator * curMolecular){
                res++;
                preMenominator = curMenominator;
                preMolecular = curMolecular;
            }
        }
        return res;
    }
}
