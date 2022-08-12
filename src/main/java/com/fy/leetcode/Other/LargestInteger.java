package com.fy.leetcode.Other;

import com.sun.xml.internal.bind.v2.model.core.ID;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Classname LargestInteger
 * @Description TODO
 * @Date 2022/4/10 10:38
 * @Created by fy
 */
public class LargestInteger {

    @Test
    public void test(){
        int num = 1234;
        largestInteger(num);
    }
    public int largestInteger(int num) {
        char[] arr = String.valueOf(num).toCharArray();
        for(int i = 0; i < arr.length; i++){
            int num1 = arr[i] - '0';
            int index1 = i;
            int num2 = num1;
            for(int j = i + 1; j < arr.length; j++){
                int tmp = arr[j] - '0';
                if(tmp % 2 == num2 % 2 && tmp > num2){
                    num2 = tmp;
                    index1 = j;
                }
            }
            char val = arr[i];
            arr[i] = arr[index1];
            arr[index1] = val;
        }
        int res = 0;
        for (char c : arr) {
            res = res * 10 + (c - '0');
        }
        return res;
    }

}
