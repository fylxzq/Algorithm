package com.fy.leetcode.Tree;

import com.fy.leetcode.Utils.TreeNode;

/**
 * @Classname IsSymmetric
 * @Description TODO
 * @Date 2022/1/21 20:51
 * @Created by fy
 */
public class IsSymmetric {
    boolean flag = true;
    public boolean isSymmetric(TreeNode root) {
        if(root == null){
            return true;
        }
        dfs(root.left, root.right);
        return flag;
    }

    public void dfs(TreeNode left,TreeNode right){
        if(left == null && right == null){
            return;
        }
        if(left == null || right == null){
            flag = false;
            return;
        }
        if(left.val != right.val){
            flag = false;
            return;
        }
        dfs(left.left,right.right);
        dfs(left.right, right.left);
    }

}
