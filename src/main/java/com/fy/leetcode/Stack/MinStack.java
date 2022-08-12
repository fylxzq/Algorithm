package com.fy.leetcode.Stack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Classname MinStack
 * @Description TODO
 * @Date 2022/1/18 11:26
 * @Created by fy
 */
public class MinStack {
    Deque<Integer> stack = new LinkedList<>();
    Deque<Integer> assitstack = new LinkedList<>();
    public MinStack() {
        assitstack.push(Integer.MAX_VALUE);
    }
    public void push(int val) {
        stack.push(val);
        if(val > assitstack.peekFirst()){
            int minvalue = assitstack.peek();
            assitstack.push(minvalue);
        }
        else{
            assitstack.push(val);
        }
    }

    public void pop() {
        stack.pop();
        assitstack.pop();
    }

    public int top() {
        return stack.peekFirst();
    }

    public int getMin() {
        return assitstack.peekFirst();
    }

}
