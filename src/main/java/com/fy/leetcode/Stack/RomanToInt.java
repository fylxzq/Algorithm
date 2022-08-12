package com.fy.leetcode.Stack;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @Classname RomanToInt
 * @Description TODO
 * @Date 2022/3/29 12:50
 * @Created by fy
 */
public class RomanToInt {
    public int romanToInt(String s) {
        Map<Character,Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X',10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        Deque<Integer> stack = new LinkedList<>();
        char[] arr = s.toCharArray();
        for(char e : arr){
            if(stack.isEmpty() || map.get(e) <= stack.peek()){
                stack.push(map.get(e));
            }
            else{
                int topvalue = stack.pop();
                stack.push(map.get(e) - topvalue);
            }
        }
        int res = 0;
        while (stack.isEmpty()){
            res += stack.pop();
        }
        return res;
    }
}
