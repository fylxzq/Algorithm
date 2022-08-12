package com.fy.leetcode.Array;


import java.util.Random;

/**
 * @Classname ArrayShuffle
 * @Description TODO
 * @Date 2022/3/18 11:22
 * @Created by fy
 */
public class ArrayShuffle {
    private Random random = new Random();
    private int[] nums;
    private int[] original;

    public ArrayShuffle(int[] nums) {
        this.nums = nums;
        int len = nums.length;
        original = new int[len];
    }

    public int[] reset() {
        System.arraycopy(original, 0, nums, 0, nums.length);
        return nums;
    }

    public int[] shuffle() {
        for(int i = 0; i < nums.length; i++){
            int randomIndex = random.nextInt(nums.length - i) + i;
            swap(i, randomIndex);
        }
        return nums;
    }
    public void swap(int i ,int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
