package com.fy.leetcode.Hash;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @Classname RearrangeCharacters
 * @Description TODO
 * @Date 2022/5/29 10:32
 * @Created by fy
 */
public class RearrangeCharacters {
    public int rearrangeCharacters(String s, String target) {
        Map<Character,Integer> map1 = new HashMap<>();
        Map<Character,Integer> map2 = new HashMap<>();
        for(char e : target.toCharArray()){
            map1.put(e, map1.getOrDefault(e, 0) + 1);
        }
        for(char e : s.toCharArray()){
            map2.put(e, map2.getOrDefault(e, 0) + 1);
        }
        int res = s.length();
        Set<Map.Entry<Character, Integer>> entries = map1.entrySet();
        for(Map.Entry<Character, Integer> entry : entries){
            char key = entry.getKey();
            int val = entry.getValue();
            if( !map2.containsKey(key)){
                return 0;
            }
            else{
                int keyNum = map2.get(key);
                res = Math.min(res, keyNum / val);
            }
        }
        return res;
    }
}
