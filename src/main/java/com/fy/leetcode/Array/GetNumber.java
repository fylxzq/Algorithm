package com.fy.leetcode.Array;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname GetNumber
 * @Description TODO
 * @Date 2022/4/24 21:20
 * @Created by fy
 */
public class GetNumber {
    @Test
    public void test(){
        int res = getNumber(new int[]{3,1,1,4,5,6});
        System.out.println(res);
    }

    public int getNumber (int[] a) {
        // write code here
        int count = 1;
        int len = a.length;
        int totalNum = len;
        while (totalNum > 1){
            for(int j = 0; j < len; j++){
                if(a[j] != 0){
                    if(!isPrime(count)){
                        a[j] = 0;
                        totalNum--;
                    }
                    count++;
                }
            }
            count = 1;
        }
        for(int i = 0; i < len; i++){
            if(a[i] != 0){
                return a[i];
            }
        }
        return 0;
    }

    private boolean isPrime(int x){
        if(x == 1){
            return false;
        }
        for(int i = x / 2; i >= 2; i--){
            if (x % i == 0){
                return false;
            }
        }
        return true;
    }
}
