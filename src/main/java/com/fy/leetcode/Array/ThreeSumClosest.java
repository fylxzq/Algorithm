package com.fy.leetcode.Array;

import org.junit.Test;

import java.util.Scanner;

/**
 * @Classname ThreeSumClosest
 * @Description TODO
 * @Date 2022/3/23 11:14
 * @Created by fy
 */
public class ThreeSumClosest {
    @Test
    public void test(){
        Scanner sc = new Scanner(System.in);
        sc.nextLine();
    }

    public int threeSumClosest(int[] nums, int target) {
        int res = nums[0] + nums[1] + nums[2];
        int len = nums.length;
        for(int first = 0; first < len - 2; first++){
            if(first > 0 && nums[first] == nums[first - 1]){
                continue;
            }
            int third = len - 1;
            int second = first + 1;
            while (second < third){
                int sumVal = nums[first] + nums[second] + nums[third];
                res = Math.abs(target - sumVal) < Math.abs(target - res) ? sumVal : res;
                if(target == sumVal){
                    return target;
                }
                else if(sumVal > target){
                    third--;
                }
                else {
                    second++;
                }
            }
        }
        return res;
    }
}
