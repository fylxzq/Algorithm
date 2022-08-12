package com.fy.leetcode.RelativeSort;

import org.junit.Test;

/**
 * @Classname NextGreaterElement
 * @Description TODO
 * @Date 2022/5/16 11:14
 * @Created by fy
 */
public class NextGreaterElement {
    @Test
    public void test(){
        nextGreaterElement(12);
    }
    public int nextGreaterElement(int n) {
        int[] bits = new int[32];
        int count = 31;
        while (n > 0){
            bits[count] = n % 10;
            n = n / 10;
            count--;
        }
        int i = 31;
        while (i > count + 1){
            if(bits[i] <= bits[i - 1]){
                i--;
            }
            else{
                break;
            }
        }
        if(i == count){
            return -1;
        }
        for(int j = 31; j >= i; j--){
            if(bits[j] > bits[i - 1]){
                swap(bits,  j ,i -1);
                break;
            }
        }
        int j = i;
        int k = 31;
        while (j < k){
            swap(bits, j, k);
            j++;
            k--;
        }
        long res = 0;
        for(int m = count + 1 ; m <= 31; m++){
            res = res * 10 + bits[m];
        }
        return res > Integer.MIN_VALUE ? -1 : (int)res;
    }

    public void swap(int[] nums,int i ,int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
