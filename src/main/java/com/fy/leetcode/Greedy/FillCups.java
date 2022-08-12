package com.fy.leetcode.Greedy;

import java.util.Arrays;

/**
 * @Classname FillCups
 * @Description TODO
 * @Date 2022/7/10 11:30
 * @Created by fy
 */
public class FillCups {
    public int fillCups(int[] amount) {
        Arrays.sort(amount);
        int count = 0;
        while (amount[2] != 0){
            amount[2]--;
            if(amount[1] > 0){
                amount[1]--;
            }
            count++;
            Arrays.sort(amount);
        }
        return count;
    }
}
