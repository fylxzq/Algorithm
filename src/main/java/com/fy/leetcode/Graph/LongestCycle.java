package com.fy.leetcode.Graph;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.zip.DataFormatException;

/**
 * @Classname LongestCycle
 * @Description TODO
 * @Date 2022/7/31 11:11
 * @Created by fy
 */
public class LongestCycle {
    int res = -1;
    boolean[] vis;
    public int longestCycle(int[] edges) {
        int len = edges.length;
        Map<Integer,Integer> map = new HashMap<>();
        vis = new boolean[len];
        for(int i = 0; i < len; i++){
            if(edges[i] != -1 && !vis[i]){
                dfs(edges, edges[i],0,map);
            }
        }
        return res;
    }

    public void dfs(int[] edge,int node,int distance,Map<Integer,Integer> map){
        if(edge[node] == -1){
            return;
        }
        if(map.containsKey(node)){
            res = Math.max(res, distance - map.get(node));
            return;
        }
        map.put(node, distance);
        vis[node] = true;
        dfs(edge, edge[node],distance + 1,map);
    }
}
