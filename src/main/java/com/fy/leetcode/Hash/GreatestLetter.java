package com.fy.leetcode.Hash;

import java.util.HashSet;
import java.util.Set;

/**
 * @Classname GreatestLetter
 * @Description TODO
 * @Date 2022/6/19 10:35
 * @Created by fy
 */
public class GreatestLetter {
    public String greatestLetter(String s) {
        Set<Character> set = new HashSet<>();
        char[] chars = s.toCharArray();
        boolean[] flafArr = new boolean[26];
        for(char e : chars){
            char otherChar;
            if(e >= 'a' && e <= 'z'){
                otherChar = (char)(e - 32);
            }
            else{
                otherChar = (char) (e + 32);
            }
            if(set.contains(otherChar)){
                int index = Math.min(e, otherChar);
                flafArr[index - 65] = true;
            }
            set.add(e);
        }
        for(int i = 25; i >= 0 ;i--){
            if(flafArr[i]){
                return String.valueOf((char)(i  + 65));
            }
        }
        return "";
    }
}
