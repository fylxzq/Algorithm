package com.fy.leetcode.Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname Tire
 * @Description TODO
 * @Date 2022/3/24 9:09
 * @Created by fy
 */
public class Trie {
    TrieNode root;
    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        char[] chars = word.toCharArray();
        TrieNode cur = root;
        for(int i = word.length() - 1; i >= 0; i--){
            int c = word.charAt(i) - 'a';
            if(cur.children[c] == null){
                cur.children[c] = new TrieNode();
            }
            cur = cur.children[c];
        }
        cur.isEnd = true;
    }

    public boolean search(String word) {
        TrieNode cur = root;
        char[] chars = word.toCharArray();
        for(char e : chars){
            int c = e - 'a';
            if(cur.children[c] == null){
                return false;
            }
            cur = cur.children[c];
        }
        return cur.isEnd;
    }

    public List<Integer> search(String sentence, int end){
        List<Integer> list = new ArrayList<>();
        TrieNode cur = root;
        for(int i = end; i >= 0; i--){
            int c = sentence.charAt(i) - 'a';
            if(cur.children[c] == null){
                break;
            }
            cur = cur.children[c];
            if(cur.isEnd){
                list.add(i);
            }
        }
        return list;
    }

    public boolean startsWith(String prefix) {
        TrieNode cur = root;
        char[] chars = prefix.toCharArray();
        for(char e : chars){
            int c = e - 'a';
            if(cur.children[c] == null){
                return false;
            }
            cur = cur.children[c];
        }
        return true;
    }

}
class TrieNode{
    boolean isEnd;
    TrieNode[] children;

    public TrieNode() {
        this.isEnd = false;
        this.children = new TrieNode[26];
    }
}
