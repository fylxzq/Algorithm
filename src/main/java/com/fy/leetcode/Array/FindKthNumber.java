package com.fy.leetcode.Array;

import org.junit.Test;
import sun.rmi.runtime.Log;

/**
 * @Classname FindKthNumber
 * @Description TODO
 * @Date 2022/4/26 22:27
 * @Created by fy
 */
public class FindKthNumber {
    @Test
    public void test(){
        System.out.println(findKthNumber(13, 5));
    }
    public int findKthNumber(int n, int k) {
        int prefix = 1;
        long totalCount = 1;
        while (totalCount < k){
            long curCount = getCount(n,prefix);
            if(totalCount + curCount > k){
                prefix *= 10;
                totalCount += 1;
            }
            else{
                prefix++;
                totalCount += curCount;
            }
        }
        return prefix;
    }


    private long getCount(int n,int k){
       long cur = k;
       long next = k + 1;
       long res = 0;
       while (cur <= n){
           res += Math.min(next, n + 1) - cur;
           cur *= 10;
           next *= 10;
       }
       return res;
    }
}
