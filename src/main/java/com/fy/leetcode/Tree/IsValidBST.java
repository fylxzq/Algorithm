package com.fy.leetcode.Tree;

import com.fy.leetcode.Utils.TreeNode;

/**
 * @Classname IsValidBST
 * @Description TODO
 * @Date 2022/1/18 16:31
 * @Created by fy
 */
public class IsValidBST {

    public boolean isValidBST(TreeNode root){
        return isValidBST(root, Integer.MIN_VALUE);

    }

    public boolean isValidBST(TreeNode root,int prev){
        if(root == null){
            return true;
        }
        boolean left = isValidBST(root.left);
        if(root.val < prev || !left){
            return false;
        }
        return isValidBST(root.right,root.val);
    }
}
