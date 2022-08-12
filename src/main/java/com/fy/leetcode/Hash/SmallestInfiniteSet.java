package com.fy.leetcode.Hash;

import java.util.HashSet;
import java.util.Set;

/**
 * @Classname SmallestInfiniteSet
 * @Description TODO
 * @Date 2022/7/10 10:41
 * @Created by fy
 */
public class SmallestInfiniteSet {
    int minNum = 1;
    Set<Integer> set;//存放被移出的元素
    public SmallestInfiniteSet() {
        set  = new HashSet<>();
    }

    public int popSmallest() {
        int curMinNum = minNum;
        set.add(curMinNum);
        while (set.contains(minNum + 1)){
            minNum++;
        }
        minNum++;
        return curMinNum;
    }

    public void addBack(int num) {
        if(num < minNum){
            minNum = num;
        }
        set.remove(num);
    }
}
