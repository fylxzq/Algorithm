package com.fy.leetcode.Strs;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @Classname RemoveKdigits
 * @Description TODO
 * @Date 2022/3/8 8:58
 * @Created by fy
 */
public class RemoveKdigits {
    @Test
    public void test() {
        String tmp = "1234567890";
        System.out.println(removeKdigits(tmp, 9));
    }

    public String removeKdigits(String num, int k) {
        char[] chars = num.toCharArray();
        int len = chars.length;
        if(k >= len || len == 1){
            return "0";
        }
        Deque<Character> stack = new ArrayDeque<>();//Õ»´æ´¢Ë÷Òý
       for(int i = 0; i < len; i++){
           char e = chars[i];
           while ( !stack.isEmpty() && k > 0 && stack.peek() > e){
               stack.pop();
               k--;
           }
           stack.push(e);
       }
       for(int i = 0; i < k; i++){
           stack.pop();
       }
       StringBuilder sb = new StringBuilder();
       boolean iszeroLeading = true;
       while ( !stack.isEmpty() ){
           if(iszeroLeading && stack.pop() == '0'){
               continue;
           }
           iszeroLeading = false;
           sb.append(stack.removeFirst());
       }
       return sb.length() == 0 ? "0" : sb.toString();
    }
}
