package com.fy.leetcode.Hash;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @Classname MinWindow
 * @Description TODO
 * @Date 2022/1/13 11:08
 * @Created by fy
 */
public class MinWindow {
    @Test
    public void test() {
        minWindow("ADOBECODEBANC", "ABC");
    }

    public String minWindow(String s, String t) {
        Map<Character, Integer> sMap = new HashMap<>();
        Map<Character, Integer> tMap = new HashMap<>();
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        for(char e : tChars){
            tMap.put(e, tMap.getOrDefault(e, 0) + 1);
        }
        int count = 0;
        int i = 0;
        int j = 0;
        int start = 0;
        int maxLen = Integer.MAX_VALUE;
        while (j < sChars.length){
            char jChar = sChars[j];
            if(tMap.containsKey(jChar)){
                sMap.put(jChar, sMap.getOrDefault(jChar, 0) + 1);
            }
            if(sMap.get(jChar).equals(tMap.get(jChar))){
                count++;
            }
            if(count == tMap.size()){
                while (count == tMap.size() ){
                    char iChar = sChars[i];
                    if(tMap.containsKey(iChar)){
                        sMap.put(iChar,sMap.get(iChar) - 1);
                    }
                    if(sMap.get(iChar) + 1 == tMap.get(iChar)){
                        count--;
                    }
                    i++;
                }
                if(j - i + 2 < maxLen){
                    start = i - 1;
                    maxLen = j - i + 2;
                }
            }
            j++;
        }
        return maxLen == Integer.MAX_VALUE ? "" : s.substring(start, start + maxLen);
    }
}
