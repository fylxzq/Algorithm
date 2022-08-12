package com.fy.leetcode.BackTrack;

import java.util.*;

/**
 * @Classname letterCombinations
 * @Description TODO
 * @Date 2022/4/13 9:13
 * @Created by fy
 */
public class letterCombinations {
    Map<Character,List<Character>> map = new HashMap<>();
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if(digits == null || digits.length() <= 0){
            return res;
        }
        map.put('2', Arrays.asList('a','b','c'));
        map.put('3', Arrays.asList('d','e','f'));
        map.put('4', Arrays.asList('g','h','i'));
        map.put('5', Arrays.asList('j','k','l'));
        map.put('6', Arrays.asList('m','n','o'));
        map.put('7', Arrays.asList('p','q','r','s'));
        map.put('8', Arrays.asList('t','u','v'));
        map.put('9', Arrays.asList('w','x','y','z'));
        int len = digits.length();
        StringBuilder sb = new StringBuilder();
        dfs(digits, 0,sb,res);
        return res;
    }

    public void dfs(String digits,int index,StringBuilder sb,List<String> res){
        if(index == digits.length()){
            res.add(sb.toString());
            return;
        }
        List<Character> list = map.get(digits.charAt(index));
        for(Character ele : list){
            sb.append(ele);
            dfs(digits, index + 1, sb, res);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
