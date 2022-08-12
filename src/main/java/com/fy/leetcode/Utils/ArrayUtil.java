package com.fy.leetcode.Utils;

import java.util.Arrays;
import java.util.Random;

/**
 * @Classname ArrayUtil
 * @Description TODO
 * @Date 2022/8/6 8:11
 * @Created by fy
 */
public class ArrayUtil {
    static Random random = new Random();
    public static int[] generateArray(int len,int upBound){
        int[] nums = new int[len];
        for(int i = 0; i < len; i++){
            nums[i] = random.nextInt(upBound);
        }
        return nums;
    }

    public static int[] generateArray(int len,int lowBound,int upBound){
        int[] nums = new int[len];
        for(int i = 0; i < len; i++){
            int flag = random.nextInt(2);
            if(flag == 1){
                nums[i] = random.nextInt(upBound);
            }
            else{
                nums[i] = -random.nextInt(lowBound);
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] ints = generateArray(10, 20,100);
        System.out.println(Arrays.toString(ints));
    }
}
