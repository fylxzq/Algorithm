package com.fy.leetcode.Strs;

/**
 * @Classname PercentageLetter
 * @Description TODO
 * @Date 2022/5/22 10:30
 * @Created by fy
 */
public class PercentageLetter {
    public int percentageLetter(String s, char letter) {
        int totalNum = 0;
        char[] chars = s.toCharArray();
        for(char e : chars){
            totalNum += e == letter ? 1 : 0;
        }
        return totalNum * 100 / chars.length;
    }
}
