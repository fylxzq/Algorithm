package com.fy.leetcode.Array;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname MinMaxGame
 * @Description TODO
 * @Date 2022/6/5 10:37
 * @Created by fy
 */
public class MinMaxGame {
    public int minMaxGame(int[] nums) {
        List<Integer> list  = new ArrayList<>();
        for(int num : nums){
            list.add(num);
        }
        while (list.size() != 1){
            ArrayList<Integer> newList = new ArrayList<>();
            int size = list.size();
            int i = 0;
            while (i < size){
                int val1 = list.get(i);
                int val2 = list.get(i + 1);
                newList.add(Math.min(val1, val2));
                i += 2;
                if(i < size){
                    int val3 = list.get(i + 1);
                    int val4 = list.get(i + 2);
                    newList.add(Math.max(val3, val4));
                    i += 2;
                }
            }
            list = newList;
        }
        return list.get(0);
    }
}
