package com.fy.leetcode.Tree;

import com.fy.leetcode.Utils.TreeNode;

/**
 * @Classname LowerCommonAncestor
 * @Description TODO
 * @Date 2021/12/23 19:01
 * @Created by fy
 */
public class LowerCommonAncestor {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q){
        if(root == null || root == p || root == q){
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);
        if(left == null && right == null){
            return null;
        }
        if(left == null) return right;
        if(right == null)  return  left;
        return root;
    }


}
