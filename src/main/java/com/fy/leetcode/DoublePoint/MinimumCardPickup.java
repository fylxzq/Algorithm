package com.fy.leetcode.DoublePoint;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * @Classname MinimumCardPickup
 * @Description TODO
 * @Date 2022/5/1 11:16
 * @Created by fy
 */
public class MinimumCardPickup {

    public int minimumCardPickup(int[] cards) {
        int i = 0;
        int j = i;
        Set<Integer> set = new HashSet<>();
        int len = cards.length;
        int res = Integer.MAX_VALUE;
        while (j < len){
            int val = cards[j];
            if( !set.contains(val)){
                set.add(val);
            }
            else{
                while (i < j && cards[i] != val){
                    i++;
                    set.remove(cards[i]);
                }
                res = Math.min(res, j - i + 1);
                set.remove(cards[i]);
                i++;
                set.add(val);
            }
            ++j;
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }
}
