package com.fy.leetcode.Tree;

import com.fy.leetcode.Utils.TreeNode;

/**
 * @Classname DiameterOfBinaryTree
 * @Description TODO
 * @Date 2022/1/18 11:39
 * @Created by fy
 */
public class DiameterOfBinaryTree {
    int rst = Integer.MIN_VALUE;
    public int diameterOfBinaryTree(TreeNode root) {
       getdepth(root);
       return rst;
    }

    public int getdepth(TreeNode root){
        if(root == null){
            return 0;
        }
        int leftdepth = getdepth(root.left);
        int rightdepth = getdepth(root.right);
        if(leftdepth + rightdepth - 1 > rst){
            rst = leftdepth + rightdepth;
        }
        return Math.max(leftdepth,rightdepth) + 1;
    }

}
