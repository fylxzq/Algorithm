package com.fy.leetcode.Graph;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @Classname ClosestMeetingNode
 * @Description TODO
 * @Date 2022/7/31 10:46
 * @Created by fy
 */
public class ClosestMeetingNode {
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        Map<Integer,Integer> map1 = new HashMap<>();
        Map<Integer,Integer> map2 = new HashMap<>();
        boolean[] vis = new boolean[edges.length];
        dfs(edges, node1, map1, 0, vis);
        Arrays.fill(vis, false);
        dfs(edges, node2, map2, 0, vis);
        Set<Map.Entry<Integer, Integer>> entries1 = map1.entrySet();
        int maxDistnace = Integer.MAX_VALUE;
        int resIndex = 0;
        for(Map.Entry<Integer, Integer> entry : entries1){
            if(map2.containsKey(entry.getKey())){
                if(Math.max(entry.getValue(),map2.get(entry.getKey())) < maxDistnace){
                    maxDistnace = Math.max(entry.getValue(),map2.get(entry.getKey()));
                    resIndex = entry.getKey();
                }
            }
        }
        return resIndex;

    }

    public void dfs(int[] edges,int node,Map<Integer,Integer> map,int distance,boolean[] vis){
        if(edges[node] == -1){
            map.put(node, distance);
            return;
        }
        if( !vis[node] ){
            map.put(node, distance);
            vis[node] = true;
            dfs(edges,edges[node],map,distance + 1,vis);
        }
    }
}
