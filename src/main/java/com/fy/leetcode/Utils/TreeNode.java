package com.fy.leetcode.Utils;

/**
 * @Classname TreeNode
 * @Description TODO
 * @Date 2022/4/16 15:40
 * @Created by fy
 */
public class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode() {
        }

        public TreeNode(int val) {
            this.val = val;
        }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
}
