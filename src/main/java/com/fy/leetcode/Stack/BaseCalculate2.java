package com.fy.leetcode.Stack;

import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Classname BaseCalculate2
 * @Description TODO
 * @Date 2022/3/9 19:27
 * @Created by fy
 */
public class BaseCalculate2 {
    @Test
    public void test() {
    }

    public int calculate(String s) {
        Deque<Integer> ops = new LinkedList<>();
        int sign = 1;
        ops.push(1);
        int sum = 0;
        int i = 0, len = s.length();
        while (i < len){
            char cur = s.charAt(i);
            if(cur == ' '){
                ++i;
            }
            else if(cur == '-'){
                sign = -ops.peek();
                ++i;
            }
            else if(cur == '+'){
                sign = ops.peek();
                ++i;
            }
            else if(cur == '('){
                ops.push(sign);
                ++i;
            }
            else if(cur == ')'){
                ops.pop();
            }
            else{
                long num = 0;
                while (i < len && Character.isDigit(cur)){
                    num = num * 10 + cur - '0';
                    ++i;
                }
                sum += (sign * num);
            }
        }
        return sum;
    }
}
