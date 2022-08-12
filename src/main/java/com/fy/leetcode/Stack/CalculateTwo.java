package com.fy.leetcode.Stack;

import org.junit.Test;

import java.lang.invoke.VolatileCallSite;
import java.util.*;

/**
 * @Classname Calculate
 * @Description TODO
 * @Date 2022/3/1 9:30
 * @Created by fy
 */
public class CalculateTwo {
    @Test
    public void test() {
        calculate("(1+(4+5+2)-3)+(6+8)");
    }

    public int calculate(String s) {
        char[] chars = s.toCharArray();
        int len = chars.length;
        int i = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(0);
        char preSign = '+';
        int res = 0;
        int num = 0;
        while (i <= len){
            while (i < len && Character.isDigit(chars[i])){
                num = num * 10 + (chars[i++] - '0');
            }
            if(i < len && chars[i] == ' '){
                i++;
            }
            else{
                switch (preSign){
                    case '+':
                        stack.push(num);
                        break;
                    case '-':
                        stack.push(-num);
                        break;
                    case '*':
                        stack.push(stack.peek() * num);
                        break;
                    default:
                        stack.push(stack.peek() / num);
                }
                if(i < len){
                    preSign = chars[i];
                }
                i++;
            }
        }
        while ( !stack.isEmpty() ){
            res += stack.pop();
        }
        return res;
    }
}
