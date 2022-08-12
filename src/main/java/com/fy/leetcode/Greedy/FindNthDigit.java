package com.fy.leetcode.Greedy;

import org.junit.Test;

/**
 * @Classname FindNthDigit
 * @Description TODO
 * @Date 2022/3/28 22:23
 * @Created by fy
 */
public class FindNthDigit {
    @Test
    public void test(){
        findNthDigit(1000000000);
    }
    public int findNthDigit(int n) {
        int width = 1;
        long length = 9;
        while(n > width * length){
            n -= (width * length);
            width++;
            length *= 10;
        }
        long start = length / 9;
        int extra = (int) ((n - 1) / width);
        int offset = width - (int) ((n -1) % width);
        int finLoc = (int)start + extra;
        int i = 0;
        int res = 0;
        while (i < offset){
            res = finLoc % 10;
            finLoc = finLoc / 10;
            i++;
        }
        return res;
    }
}
