package com.fy.leetcode.Stack;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @Classname RemoveKdigits
 * @Description TODO
 * @Date 2022/7/30 20:08
 * @Created by fy
 */
public class RemoveKdigits {
    public String removeKdigits(String num, int k) {
        char[] chars = num.toCharArray();
        Deque<Character> deque = new LinkedList<>();
        for(char e : chars){
            if(deque.isEmpty() || e >= deque.peekLast()){
                deque.offerLast(e);
            }
            else{
                while (k > 0 && !deque.isEmpty() && deque.peekLast() > e){
                    deque.pollLast();
                    k--;
                }
                deque.offerLast(e);
            }
        }
        while (!deque.isEmpty() && deque.pollFirst() == '0'){
            deque.pollFirst();
        }
        StringBuilder sb = new StringBuilder();
        while (!deque.isEmpty()){
            sb.append(deque.pollFirst());
        }
        return sb.toString();
    }
}
