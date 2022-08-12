package com.fy.leetcode.Tree;

import java.util.Arrays;

/**
 * @Classname MinimumLengthEncoding
 * @Description TODO
 * @Date 2022/4/27 9:19
 * @Created by fy
 */
public class MinimumLengthEncoding extends Trie{
    public int minimumLengthEncoding(String[] words) {
        Arrays.sort(words, (str1,str2) -> {
            return str2.length() - str1.length();
        });
        int res = 0;
        for(String word : words){
            res += Myinsert(word);
        }
        return res;
    }


    public int Myinsert(String word) {
        boolean isEnd = false;
        TrieNode cur = root;
        for(int i = word.length() - 1; i>= 0; i--){
            int c = word.charAt(i) - 'a';
            if(cur.children[c] == null){
                cur.children[c] = new TrieNode();
                isEnd = true;
            }
            cur = cur.children[c];
        }
        return isEnd ? 0 : word.length() + 1;
    }
}


