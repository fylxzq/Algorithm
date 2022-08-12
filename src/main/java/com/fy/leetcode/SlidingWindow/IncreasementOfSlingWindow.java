package com.fy.leetcode.SlidingWindow;

/**
 * @Classname IncreasementOfSlingWindow
 * @Description TODO
 * @Date 2021/8/5 8:50
 * @Created by fy
 */
public class IncreasementOfSlingWindow {
    /*
    *
    * 滑动窗口平均值增幅
    * */

    public float incrementofsw(int[] arr,int k){
        int len = arr.length;
        int i = 0;
        int j = 0;
        float sum = 0;
        float rst = 0;
        while (j < len){
            if(j < k){
                sum += (float)arr[j];
                ++j;
            }
            else{
                float pre_sum = sum;
                sum -= arr[i];
                sum += arr[j];
                System.out.println(sum / pre_sum);
                rst = Math.max(rst, sum / pre_sum - 1);
                ++i;
                ++j;
            }
        }
        return rst;
    }
}
