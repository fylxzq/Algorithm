package com.fy.leetcode.Array;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Classname RemoveDuplicates
 * @Description TODO
 * @Date 2022/4/30 21:53
 * @Created by fy
 */
public class RemoveDuplicates  {
    public String removeDuplicates(String s) {
        Deque<Character> stack = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        for(char e : s.toCharArray()){
            if(stack.isEmpty() || stack.peek() != e){
                stack.push(e);
            }
            else{
                stack.pop();
            }
        }
        while (!stack.isEmpty()){
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }
}
