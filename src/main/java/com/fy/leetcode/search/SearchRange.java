package com.fy.leetcode.search;

import org.junit.Test;

/**
 * @Classname SearchRange
 * @Description TODO
 * @Date 2022/2/25 13:14
 * @Created by fy
 */
public class SearchRange {
    @Test
    public void test() {
        int[] nums = new int[]{5, 7, 7, 8, 8, 10};
        System.out.println();
    }

    public int[] searchRange(int[] nums, int target) {
        int l = binarySearch(nums, target);
        int r = binarySearch(nums, target + 1);
        if (l == nums.length || nums[l] != target) {
            return new int[]{-1, -1};
        } else {
            return new int[]{l, r - 1};
        }
    }

    public int binarySearch(int[] nums, int target) {//找到第一个大于等于target的书
        int low = 0, high = nums.length ;
        while (low < high) {
            int mid = (low + high) >> 1;
            if (nums[mid] >= target) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }


}
