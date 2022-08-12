package com.fy.leetcode.DynamicProgramming;

import org.junit.Test;

import java.util.*;

/**
 * @Classname ReceiveRainWater
 * @Description TODO
 * @Date 2021/12/30 16:18
 * @Created by fy
 */
public class ReceiveRainWater {

    @Test
    public void test(){
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
//        int rst = trap(height);
//        System.out.println(rst);
    }
    public int trapDynamic(int [] height){
        int len = height.length;
        if(len < 3){
            return 0;
        }
        int[] leftmax = new int[len];
        int[] rightmax = new int[len];
        leftmax[0] = height[0];
        rightmax[len - 1] = height[len - 1];
        for(int i = 1; i < len; ++i){
            leftmax[i] = Math.max(leftmax[i -1],height[i]);
        }
        for(int i = len - 2; i >= 0 ; --i){
            rightmax[i] = Math.max(rightmax[i + 1],height[i]);
        }
        int rst = 0;
        for(int i = 0; i < len ; ++i){
            rst += Math.max(leftmax[i],rightmax[i]) - height[i];
        }
        return rst;
    }

    public int trapMonotonousStack(int[] height){
        Deque<Integer> stack = new LinkedList<>();
        int len = height.length;
        if(len < 3){
            return 0;
        }
        int rst = 0;
        for(int i = 0; i< len; ++i){
            while ( !stack.isEmpty() && height[i] > stack.peek()){
                int top = stack.peek();
                if(stack.isEmpty()){
                    break;
                }
                int left = stack.peek();
                int curwidth = i - left - 1;
                int curheight = Math.min(height[left],height[i]) - height[top];
                rst += curheight * curwidth;
            }
            stack.push(i);
        }
        return rst;
    }

    public int trapDoublePoint(int[] height){
        int len = height.length;
        if(len < 3){
            return 0;
        }
        int rst = 0;
        int left = 0;
        int right = len - 1;
        int leftmax = 0;
        int rightmax = 0;
        while (left < right){
            leftmax = Math.max(height[left],leftmax);
            rightmax = Math.max(height[right],rightmax);
            if(height[left] >= height[right]){
                rst += (rightmax - height[right]);
                --right;
            }
            else{
                rst += (leftmax - height[left]);
                ++left;
            }
        }
        return rst ;
    }
}
