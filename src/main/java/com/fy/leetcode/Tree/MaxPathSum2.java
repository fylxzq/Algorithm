package com.fy.leetcode.Tree;

/**
 * @Classname MaxPathSum2
 * @Description TODO
 * @Date 2022/8/1 14:46
 * @Created by fy
 */
public class MaxPathSum2 {
    public static void main(String[] args) {
        int n = 5;
        int[] trees = {-20,8,20,15,6};
        int[] parents ={0,1,1,3,3};
        int[] memory = new int[n];
        for(int i = 0; i < n; i++){
            memory[i] = trees[i];
        }
        int res = Integer.MIN_VALUE;
        for(int i = n - 1; i >= 0; i--){
            res = Math.max(trees[i],res);
            if(parents[i] != 0){
                res = Math.max(memory[parents[i] - 1] + memory[i],res);
                memory[parents[i] - 1] = Math.max(memory[parents[i] - 1],memory[i] + trees[parents[i - 1]]);
            }
        }
        System.out.println(res);
    }
}
