package com.fy.leetcode.Stack;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @Classname ValidBrackets
 * @Description TODO
 * @Date 2021/12/23 17:20
 * @Created by fy
 */
public class ValidBrackets {

    public static void main(String[] args) {
        ValidBrackets v = new ValidBrackets();
        String s = "()[]{}";
        System.out.println(v.isValid(s));
    }
    public boolean isValid(String s){
        Deque<Character> stack = new LinkedList<Character>();
        Map<Character,Character> pair = new HashMap<Character, Character>();
        pair.put(')', '(');
        pair.put(']', ']');
        pair.put('}', '{');
        int len = s.length();
        for(int i = 0; i < len; ++i){
            char tmp = s.charAt(i);
            if(tmp == '(' || tmp == '[' || tmp == '{'){
                stack.push(tmp);
            }
            else{
                if(stack.isEmpty()){
                    return false;
                }
                char top_value = stack.pop();
                if(top_value != pair.get(tmp)){
                    return false;
                }
            }
        }
        if(stack.isEmpty()){
            return true;
        }
        else{
            return false;
        }
    }
}
