package com.fy.leetcode.Array;

/**
 * @Classname CanJump
 * @Description TODO
 * @Date 2022/4/27 13:56
 * @Created by fy
 */
public class CanJump {
    public boolean canJump(int[] nums) {
        int maxJump = nums[0];
        for(int i = 1; i < nums.length; i++){
            if(maxJump >= i){
                maxJump = Math.max(i + nums[i],maxJump);
            }
            else{
                return false;
            }
        }
        return true;
    }
}
