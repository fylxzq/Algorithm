package com.fy.leetcode.Stack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Classname TotalSteps
 * @Description TODO
 * @Date 2022/5/29 22:12
 * @Created by fy
 */
public class TotalSteps {
    public int totalSteps(int[] nums) {
        int res = 0;
        int[] f = new int[nums.length];//记录nums[i]被删除的轮数
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < nums.length; i++){
            int cur = 0;
            while ( !stack.isEmpty() && nums[i] >= nums[stack.peek()]){
                cur = Math.max(cur, f[stack.pop()]);
            }
            if( !stack.isEmpty() ){
                res = Math.max(res, cur + 1);
                f[i] = cur + 1;
            }
            stack.push(i);
        }
        return res;
    }
}
