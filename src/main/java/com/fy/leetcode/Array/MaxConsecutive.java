package com.fy.leetcode.Array;

import java.util.Arrays;

/**
 * @Classname MaxConsecutive
 * @Description TODO
 * @Date 2022/5/15 10:50
 * @Created by fy
 */
public class MaxConsecutive {
    public int maxConsecutive(int bottom, int top, int[] special) {
        Arrays.sort(special);
        int res = 0;
        res = Math.max(special[0] - bottom,res);
        res = Math.max(special[special.length - 1] - top,res);
        for(int i = 1; i < special.length; i++){
            res = Math.max(res, special[i] - special[i - 1] - 1);
        }
        return res;
    }
}
