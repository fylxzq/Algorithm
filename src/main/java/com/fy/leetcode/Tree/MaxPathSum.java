package com.fy.leetcode.Tree;

import com.fy.leetcode.Utils.TreeNode;

/**
 * @Classname MaxPathSum
 * @Description TODO
 * @Date 2022/1/6 11:25
 * @Created by fy
 */
public class MaxPathSum {
    //[1,-2,-3,1,3,-2,null,-1]
    int rst = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        getMaxGain(root);
        return rst;
    }
    public int getMaxGain(TreeNode root){
        if(root == null){
            return 0;
        }
        int leftMaxGain = Math.max(getMaxGain(root.left),0);
        int rightMaxGain = Math.max(getMaxGain(root.right),0);

        int maxGain = leftMaxGain + rightMaxGain + root.val;
        rst = Math.max(rst, maxGain);
        return maxGain;
    }
}
