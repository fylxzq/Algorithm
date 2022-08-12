package com.fy.leetcode.Tree;

/**
 * @Classname WordDictionary
 * @Description TODO
 * @Date 2022/4/27 9:48
 * @Created by fy
 */
public class WordDictionary {
    TrieNode root;
    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode cur = root;
        char[] chars = word.toCharArray();
        for(char e : chars){
            int c = e - 'a';
            if(cur.children[c] == null){
                cur.children[c] = new TrieNode();
            }
            cur = cur.children[c];
        }
        cur.isEnd = true;
    }

    public boolean search(String word) {
        return isMatch(word, 0, root);
    }

    public boolean isMatch(String word,int start,TrieNode cur){
        if(word.length() == start){
            return cur.isEnd;
        }
        if(word.charAt(start) != '.'){
            int c = word.charAt(start) - 'a';
            return cur.children[c] != null && isMatch(word, start + 1, cur.children[c]);
        }
        else{
            for(int i = 0; i < 26; i++){
                if(cur.children[i] != null && isMatch(word, start, cur.children[i])){
                    return true;
                }
            }
        }
        return false;
    }
}
