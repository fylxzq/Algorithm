package com.fy.leetcode.Graph;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @Classname CourseOrder
 * @Description TODO
 * @Date 2022/3/31 9:00
 * @Created by fy
 */
public class CourseOrder {
    boolean isValid = true;
    int count = 0;
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        count = numCourses - 1;
        int[] res = new int[numCourses];
        List<List<Integer>> edges = new ArrayList<>();
        for(int i = 0; i < numCourses; i++){
            edges.add(new ArrayList<>());
        }
        for (int[]  prerequisite: prerequisites){
            edges.get(prerequisite[1]).add(prerequisite[0]);
        }
        int[] vis = new int[numCourses];
        for(int i = 0; i < numCourses; i++){
            if(isValid){
                dfs(res,edges,i,vis);
            }
        }
        return count == 0 ? res : new int[]{};
    }

    public void dfs(int[] res,List<List<Integer>> edges,int curCourse,int[] vis){
        vis[curCourse] = 1;
        List<Integer> oneEdges = edges.get(curCourse);
        for(int edge : oneEdges){
            if(vis[edge] == 0 && isValid){
                dfs(res, edges, edge, vis);
            }
            if(vis[edge] == 1){
                isValid = false;
            }
        }
        if(isValid){
            res[count] = curCourse;
            count--;
            vis[curCourse] = 2;
        }
    }
}
