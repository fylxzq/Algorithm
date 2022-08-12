package com.fy.leetcode.Hash;

import java.util.HashSet;
import java.util.Set;

/**
 * @Classname RepeatedCharacter
 * @Description TODO
 * @Date 2022/7/24 10:31
 * @Created by fy
 */
public class RepeatedCharacter {
    public char repeatedCharacter(String s) {
        Set<Character> set = new HashSet<>();
        char[] chars = s.toCharArray();
        for(char e : chars){
            if(set.contains(e)){
                return e;
            }
            set.add(e);
        }
        return 'a';
    }
}
