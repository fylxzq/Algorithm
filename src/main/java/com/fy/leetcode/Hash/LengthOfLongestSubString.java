package com.fy.leetcode.Hash;

import org.junit.Test;

import java.util.HashMap;

/**
 * @Classname LengthOfLongestSubString
 * @Description TODO
 * @Date 2021/7/23 8:46
 * @Created by fy
 */
public class LengthOfLongestSubString {


    public int lengthoflongestsubstring(String s){
        int len = s.length();
        HashMap<Character,Integer> table = new HashMap<Character, Integer>();
        int i = 0,j = 0;
        int max = 0;
        while (j < len){
            if (!table.containsKey(s.charAt(j))){
                table.put(s.charAt(j), 1);
                ++j;
                if(j-i > max){
                    max = j - i;
                }//放在if里面
            }
            else{
                table.remove(s.charAt(i));
                ++i;
            }
        }
        return max;

    }
}
