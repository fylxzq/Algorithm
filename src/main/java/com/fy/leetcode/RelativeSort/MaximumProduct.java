package com.fy.leetcode.RelativeSort;

import org.junit.Test;

import java.util.Map;
import java.util.PriorityQueue;

/**
 * @Classname MaximumProduct
 * @Description TODO
 * @Date 2022/4/10 11:42
 * @Created by fy
 */
public class MaximumProduct {
    @Test
    public void test(){
        int[] nums = {0,4};
        maximumProduct(nums, 5);
    }
    public int maximumProduct(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(int num : nums){
            queue.add(num);
        }
        for(int i = 0; i < k; i++){
            int val = queue.poll();
            queue.add(val + 1);
        }
        int res = 1;
        while (queue.isEmpty()){
            res = res * queue.poll();
            res = res % ((int) Math.pow(10, 9) + 7);
        }
        return res;
    }
}
