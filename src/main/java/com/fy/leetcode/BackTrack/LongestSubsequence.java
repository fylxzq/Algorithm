package com.fy.leetcode.BackTrack;

import org.junit.Test;

import java.time.Year;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * @Classname LongestSubsequence
 * @Description TODO
 * @Date 2022/6/19 11:23
 * @Created by fy
 */
public class LongestSubsequence {
    @Test
    public void test(){
        String s = "1001010";
        longestSubsequence(s, 5);

    }
    int res = Integer.MAX_VALUE;
    public int longestSubsequence(String s, int k) {
        Deque<Integer> deque = new LinkedList<>();
        dfs(s, 0, deque, k);
        return res;
    }

    public void dfs(String s, int index, Deque<Integer> queue,int k){
        if (index == s.length()){
            calculate(queue,k);
            return;
        }
        char c = s.charAt(index);
        int bit = c - '0';
        queue.addFirst(bit);
        dfs(s, index + 1, queue, k);
        queue.removeFirst();
        dfs(s, index + 1, queue, k);
    }

    public void calculate(Deque<Integer> deque,int k){
        int tmpRes = 0;
        Iterator<Integer> iterator = deque.iterator();
        int carry = 1;
        while (iterator.hasNext()){
            tmpRes += iterator.next() * carry;
            carry *= 2;
        }
        if(tmpRes <= k){
            res = Math.min(res, deque.size());
        }
    }
}
