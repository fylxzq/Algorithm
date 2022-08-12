package com.fy.leetcode.Array;

/**
 * @Classname CanCompleteCircuit
 * @Description TODO
 * @Date 2022/3/29 11:01
 * @Created by fy
 */
public class CanCompleteCircuit {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int len = gas.length;
        int start = 0;
        int index = 0;
        int pregas = 0;
        int precost = 0;
        boolean[] visited = new boolean[len];
        while (true){
            visited[index] = true;
            if(pregas + gas[index] >= precost + cost[index]){
                pregas = pregas + gas[index];
                precost = precost + cost[index];
                index = (index + 1) % len;
                if(index == start){
                    return start;
                }
            }
            else{
                pregas = 0;
                precost = 0;
                index = (index + 1) % len;
                if(visited[index]){
                    return -1;
                }
            }
        }
    }
}
