package com.fy.leetcode.DynamicProgramming;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @Classname MaxStockProfit
 * @Description TODO
 * @Date 2021/12/22 9:46
 * @Created by fy
 */
public class MaxStockProfit {


    public int maxProfit(int[] prices){
        int len = prices.length;
        int min_preice = Integer.MAX_VALUE;
        int rst = 0;
        for(int i = 0;i < len; ++i){
            if(prices[i] - min_preice > rst){
                rst = prices[i] - min_preice;
            }
            min_preice = Math.min(prices[i],min_preice);
        }
        return rst;
    }
}
