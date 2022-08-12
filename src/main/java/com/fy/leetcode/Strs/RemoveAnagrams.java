package com.fy.leetcode.Strs;

import java.util.*;

/**
 * @Classname RemoveAnagrams
 * @Description TODO
 * @Date 2022/5/15 10:34
 * @Created by fy
 */
public class RemoveAnagrams {
    public List<String> removeAnagrams(String[] words) {
        int i = 0;
        int j = 1;
        List<String> res = new ArrayList<>();
        while (j <= words.length){
            if(j == words.length || !isAnagrams(words[i],words[j])){
                res.add(words[i]);
                i = j;
            }
            j++;
        }
        return res;
    }

    public boolean isAnagrams(String str1, String str2){
        if(str1.length() != str2.length()){
            return false;
        }
        Map<Character,Integer> map1 = new HashMap<>();
        Map<Character,Integer> map2 = new HashMap<>();
        for(int i = 0; i < str1.length(); i++){
            map1.put(str1.charAt(i), map1.getOrDefault(str1.charAt(i), 0) + 1);
            map2.put(str2.charAt(i), map2.getOrDefault(str2.charAt(i), 0) + 1);
        }
        Set<Map.Entry<Character, Integer>> entries = map1.entrySet();
        for(Map.Entry<Character, Integer> entry : entries){
            if(map2.get(entry.getKey()) != entry.getValue()){
                return false;
            }
        }
        return true;
    }
}
