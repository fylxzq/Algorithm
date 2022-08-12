package com.fy.leetcode.Graph;

import java.util.*;

/**
 * @Classname CanFinishCourse
 * @Description TODO
 * @Date 2021/8/28 10:44
 * @Created by fy
 */
public class CanFinishCourse {


    public int[] canFinish(int numCourses,int[][] prerequisites){
        List<List<Integer>> g = new ArrayList<>();
        for(int i = 0; i < numCourses; i++){
            g.add(new ArrayList<>());
        }
        for(int[] prerequisite : prerequisites){
            g.get(prerequisite[1]).add(prerequisite[0]);
        }
        int[] used = new int[numCourses];
        boolean res = true;
        Deque<Integer> seq = new LinkedList<>();
        for(int i = 0; i < numCourses; i++){
            if(used[i] == 0){
                res = res && dfs(g, i, used,seq);
            }
        }
        if(res){
            int[] resseq = new int[numCourses];
            for(int i = 0; i < numCourses; i++){
                resseq[i] = seq.pollFirst();
            }
        }
        return new int[]{0};

//        int[] indgree = new int[numCourses];
//        for(int i = 0; i < numCourses; i++){
//            for(int courseNum : g.get(i)){
//                indgree[numCourses]++;
//            }
//        }
//        Deque<Integer> deque = new LinkedList<>();
//        for(int i = 0; i < numCourses; i++){
//            if(indgree[i] == 0){
//                deque.offer(i);
//            }
//        }
//        int count = 0;
//        while ( !deque.isEmpty() ){
//            count++;
//            int courseNum = deque.poll();
//            for(int nextCourseNum : g.get(courseNum)){
//                indgree[nextCourseNum]--;
//                if(indgree[nextCourseNum] == 0){
//                    deque.offer(nextCourseNum);
//                }
//            }
//        }
//        return count == numCourses;
    }
    public boolean dfs(List<List<Integer>> g,int courseNum,int[] used,Deque<Integer> seq){
        if(used[courseNum] == 2){
            return true;
        }
        used[courseNum] = 1;
        boolean flag = true;
        for(int nextCourseNum : g.get(courseNum)){
            if(used[nextCourseNum] == 1){
                return false;
            }
            flag = flag && dfs(g, nextCourseNum, used,seq);
        }
        used[courseNum] = 2;
        seq.addFirst(courseNum);
        return flag;
    }

}
