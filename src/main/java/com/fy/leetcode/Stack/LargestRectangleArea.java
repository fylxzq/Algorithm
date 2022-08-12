package com.fy.leetcode.Stack;

import com.sun.xml.internal.fastinfoset.tools.StAX2SAXReader;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * @Classname LargestRectangleArea
 * @Description TODO
 * @Date 2022/5/31 16:00
 * @Created by fy
 */
public class LargestRectangleArea {
    public int largestRectangleArea(int[] heights) {
        Deque<Integer> stack = new ArrayDeque<>();
        int len = heights.length;
        int[] newHeights = new int[len + 2];
        int res = 0;
        System.arraycopy(heights,0,newHeights, 1, len);
        for(int i = 0; i <= len + 1; i++){
            if(stack.isEmpty() || newHeights[stack.peek()] <= newHeights[i]){
                stack.push(i);
            }
            else{
                while ( !stack.isEmpty() && newHeights[stack.peek()] > newHeights[i]){
                    int index = stack.pop();
                    int curRes = newHeights[index] * (i - stack.peek() - 1);
                    res = Math.max(res, curRes);
                }
                stack.push(i);
            }
        }
        return res;
    }
}
