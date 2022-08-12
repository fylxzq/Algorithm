package com.fy.leetcode.Greedy;

import org.junit.Test;

/**
 * @Classname Candy
 * @Description TODO
 * @Date 2022/6/30 20:07
 * @Created by fy
 */
public class Candy {
    @Test
    public void test(){
        int[] nums = new int[]{1,3,2,2,1};
        System.out.println(candy(nums));
    }

    public int candy(int[] ratings) {
        int len = ratings.length;
        int res = 0;
        int[] left = new int[len];
        for(int i = 0; i < len; i++){
            if(i > 0 && ratings[i] > ratings[i - 1]){
                left[i] = left[i - 1] + 1;
            }
            else{
                left[i] = 1;
            }
        }
        int right = 0;
        for(int i = len - 1; i >= 0; i--){
            if(i < len - 1 && ratings[i] > ratings[i + 1]){
                ratings[i] = right++;
            }
            else{
                right = 1;
            }
            res += Math.max(left[i],right);
        }
        return res;
    }
}
