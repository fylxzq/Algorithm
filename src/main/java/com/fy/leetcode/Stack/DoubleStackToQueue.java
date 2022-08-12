package com.fy.leetcode.Stack;

import java.util.*;

/**
 * @Classname DoubleStackToQueue
 * @Description TODO
 * @Date 2022/1/3 19:25
 * @Created by fy
 */
public class DoubleStackToQueue {
    Deque<Integer> stack1;
    Deque<Integer> stack2;
    public DoubleStackToQueue() {
        stack1 = new LinkedList<>();
        stack2 = new LinkedList<>();
    }

    public void push(int x){
        if( !stack2.isEmpty() ){
            while (!stack2.isEmpty()){
                int tmpvalue = stack2.pop();
                stack1.push(tmpvalue);
            }
        }
        stack1.push(x);
    }

    public int pop(){
        if( !stack1.isEmpty() ){
            while ( !stack1.isEmpty() ){
                int tmpvalue = stack1.pop();
                stack2.push(tmpvalue);
            }
        }
        return stack2.pop();
    }

    public int peek(){
        if( !stack1.isEmpty() ){
            while ( !stack1.isEmpty() ){
                int tmpvalue = stack1.pop();
                stack2.push(tmpvalue);
            }
        }
        return stack2.peek();
    }

    public boolean empty(){
        return stack1.isEmpty();
    }

}
