package com.fy.leetcode.BackTrack;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @Classname JudgePoint24
 * @Description TODO
 * @Date 2022/5/15 9:43
 * @Created by fy
 */
public class JudgePoint24 {


    public boolean judgePoint24(int[] cards) {
        List<Double> list = new ArrayList<>();
        for (int card : cards) {
            list.add((double) card);
        }
        return dfs(list);
    }

    public boolean dfs(List<Double> list) {
       int size = list.size();
       if(size == 1){
           return Math.abs(list.get(0) - 24) <= 0.00001;
       }
       for(int i = 0; i < size - 1; i++){
           for(int j = i + 1; j < size; j++){
               List<Double> copy = new ArrayList<>(list);
               double a = copy.remove(i);
               double b = copy.remove(j);
               boolean valid = false;
               copy.add(a + b);
               valid |= dfs(copy);
               copy.set(copy.size() - 1, a - b);
               valid |= dfs(copy);
               copy.set(copy.size() - 1, a * b);
               valid |= dfs(copy);
               copy.set(copy.size() - 1, a / b);
               valid |= dfs(copy);
               copy.set(copy.size() - 1, b - a);
               valid |= dfs(copy);
               copy.set(copy.size() - 1, b / a);
               valid |= dfs(copy);
           }
       }
       return false;
    }
}
