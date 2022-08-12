package com.fy.leetcode.Tree;

import com.fy.leetcode.Utils.TreeNode;

/**
 * @Classname TreeToDoublyList
 * @Description TODO
 * @Date 2022/4/18 12:47
 * @Created by fy
 */
public class TreeToDoublyList {
    TreeNode pre = null;
    public TreeNode treeToDoublyList(TreeNode root) {
        TreeNode head = root;
        TreeNode tail = root;
        while (head.left != null){
            head = head.left;
        }
        while (tail.right != null){
            tail = tail.right;
        }
        dfs(root);
        head.left = tail;
        tail.right = head;
        return head;
    }
    public void dfs(TreeNode root){
        if(root == null){
            return;
        }
        dfs(root.left);
        if(pre != null && pre.right == null){
            pre.right = root;
        }
        if(root.left == null){
            root.left = pre;
        }
        pre = root;
        dfs(root.right);
    }

}
