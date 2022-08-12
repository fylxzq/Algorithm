package com.fy.leetcode.Recursion;

/**
 * @Classname LastRemaining
 * @Description TODO
 * @Date 2022/4/23 13:55
 * @Created by fy
 */
public class LastRemaining {

    public int lastRemaining(int n, int m) {
        System.out.println();
        return ysf(n, m, m);
    }

    public int ysf(int n,int m,int seq){
        if(seq == 1){
            return (m - 1) % n;
        }
        else{
            return (ysf(n - 1, m, seq - 1) + m ) % n;
        }
    }
}
