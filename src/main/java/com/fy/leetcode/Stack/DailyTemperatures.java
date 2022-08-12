package com.fy.leetcode.Stack;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @Classname DailyTemperatures
 * @Description TODO
 * @Date 2022/3/12 12:33
 * @Created by fy
 */
public class DailyTemperatures {
    @Test
    public void test() {
    }

    public int[] dailyTemperatures(int[] temperatures) {
        int[] resArr = new int[temperatures.length];
        Deque<Integer> stack = new ArrayDeque<>();
        for(int i = 0; i < temperatures.length; i++){
            if(stack.isEmpty() || temperatures[stack.peek()] >= temperatures[i]){
                stack.push(i);
            }
            else{
                while ( !stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]){
                    int index = stack.pop();
                    resArr[index] = i - index;
                }
                stack.push(i);
            }
        }
        while ( !stack.isEmpty() ){
            resArr[stack.pop()] = 0;
        }
        return resArr;
    }
}
