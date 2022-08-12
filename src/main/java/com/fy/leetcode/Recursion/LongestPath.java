package com.fy.leetcode.Recursion;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname LongestPath
 * @Description TODO
 * @Date 2022/4/17 11:34
 * @Created by fy
 */

/*
* 给你一棵 树（即一个连通、无向、无环图），根节点是节点 0 ，这棵树由编号从 0 到 n - 1 的 n 个节点组成。用下标从 0 开始、长度为 n 的数组 parent 来表示这棵树，其中 parent[i] 是节点 i 的父节点，由于节点 0 是根节点，所以 parent[0] == -1 。

另给你一个字符串 s ，长度也是 n ，其中 s[i] 表示分配给节点 i 的字符。

请你找出路径上任意一对相邻节点都没有分配到相同字符的 最长路径 ，并返回该路径的长度。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/longest-path-with-different-adjacent-characters
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
* */
public class LongestPath {


    int res = 1;
    public int longestPath(int[] parent, String s) {
        List<List<Integer>> g = new ArrayList<>();
        for(int i = 0; i < parent.length; i++){
            g.add(new ArrayList<>());
        }
        int root = 0;
        for(int i = 0; i < parent.length; i++){
           if(parent[i] == -1){
               root = i;
           }
           else{
               g.get(parent[i]).add(i);
           }
       }
        dfs(root, g, s);
        return res;
    }

    private int dfs(int root,List<List<Integer>> g,String s){
        int max1 = 0;
        int max2 = 0;
        List<Integer> sons = g.get(root);
        for(int son : sons){
            int d = dfs(son, g, s);
            if(s.charAt(son) == s.charAt(root)){
                continue;
            }
            if(d > max1){
                max2 = max1;
                max1 = d;
            }
            else if(d > max2){
                max2 = d;
            }
            res = Math.max(res, max1 + max2 + 1);
        }
        return max1 + 1;
    }
}
