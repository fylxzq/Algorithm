package com.fy.leetcode.Tree;

import com.fy.leetcode.Utils.TreeNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.List;

/**
 * @Classname PathSum
 * @Description TODO
 * @Date 2022/1/16 22:24
 * @Created by fy
 */
public class PathSum {

    @Test
    public void test(){

    }
    public List<List<Integer>> pathSum(TreeNode root, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> one_res = new ArrayList<>();
        dfs(root,target,res,one_res);
        return res;
    }

    private void dfs(TreeNode root, int target, List<List<Integer>> res, List<Integer> one_res){
        if(root == null){
            return;
        }
        one_res.add(root.val);
        if(root.val == target && root.left == null && root.right == null){
            res.add(new ArrayList<>(one_res));
            return;
        }
        dfs(root.left,target - root.val,res,one_res);
        dfs(root.right,target - root.val,res,one_res);
        one_res.remove(one_res.size() - 1);
    }
}
