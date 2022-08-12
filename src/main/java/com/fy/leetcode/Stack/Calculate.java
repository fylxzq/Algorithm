package com.fy.leetcode.Stack;

import org.junit.Test;
import sun.plugin.WJcovUtil;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @Classname Calculate
 * @Description TODO
 * @Date 2022/4/15 15:48
 * @Created by fy
 */
public class Calculate {
    @Test
    public void test(){
    }

    public int calculate(String s) {
        Deque<Integer> ops = new LinkedList<>();
        int sign = 1;
        ops.push(1);
        char[] chars = s.toCharArray();
        int len = chars.length;
        int res = 0;
        int i = 0;
        while (i < len){
           char e = chars[i];
           if(e == ' '){
               i++;
           }
           else if(e == '('){
               ops.push(sign);
               i++;
           }
           else if(e == ')'){
               sign = ops.pop();
               i++;
           }
           else if(e == '+'){
               sign = ops.peek();
               i++;
           }
           else if(e == '-'){
               sign = -ops.peek();
               i++;
           }
           else{
               int num = 0;
               while (i < len && Character.isDigit(chars[i])){
                   num = num * 10 + (chars[i] - '0');
                   i++;
               }
               res += (sign * num);
           }
        }
        return res;
    }
}
