package com.fy.leetcode.Stack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Classname CheckValidString
 * @Description TODO
 * @Date 2022/5/1 10:06
 * @Created by fy
 */
public class CheckValidString {
    public boolean checkValidString(String s) {
        Deque<Integer> stack = new LinkedList<>();
        Deque<Integer> assit_stack = new LinkedList<>();
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '('){
                stack.push(i);
            }
            else if(s.charAt(i) == '*'){
                assit_stack.push(i);
            }
            else{
                if(stack.isEmpty() && assit_stack.isEmpty()){
                    return false;
                }
                else if(!stack.isEmpty()){
                    stack.pop();
                }
                else{
                    assit_stack.pop();
                }
            }
        }
        while ( !stack.isEmpty()){
            if(!assit_stack.isEmpty() && stack.peek() < assit_stack.peek()){
                stack.pop();
                assit_stack.pop();
            }
            else{
                return false;
            }
        }
        return true;
    }
}
