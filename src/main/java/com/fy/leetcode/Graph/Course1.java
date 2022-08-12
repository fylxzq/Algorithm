package com.fy.leetcode.Graph;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @Classname Course1
 * @Description TODO
 * @Date 2022/3/10 19:42
 * @Created by fy
 */
public class Course1 {
    @Test
    public void test() {
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> g = new ArrayList<>();
        for(int i = 0; i < numCourses; ++i){
            g.add(new ArrayList<>());
        }
        int[] in_degree = new int[numCourses];
        List<Integer> res = new ArrayList<>();
        Deque<Integer> deque = new LinkedList<>();
        for(int i = 0; i < prerequisites.length; ++i){
            g.get(prerequisites[i][1]).add(prerequisites[i][0]);
            in_degree[prerequisites[i][0]]++;
        }
        for(int i = 0; i < numCourses; ++i){
            if(in_degree[i] == 0){
                deque.offerLast(i);
            }
        }
        while ( !deque.isEmpty() ){
            int cur_node = deque.pollFirst();
            res.add(cur_node);
            List<Integer> edges = g.get(cur_node);
            for(int nextnode : edges){
                in_degree[nextnode]--;
                if(in_degree[nextnode] == 0){
                    deque.offerLast(nextnode);
                }
            }
        }
        return res.size() == numCourses;
    }
}
