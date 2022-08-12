package com.fy.leetcode.Tree;

import com.fy.leetcode.Utils.TreeNode;
import org.junit.Test;

/**
 * @Classname BinarySearchTree
 * @Description TODO
 * @Date 2022/3/24 12:35
 * @Created by fy
 */
public class BinarySearchTree {

    @Test
    public void test(){
        int[] nums = {6,2,3,1,5,7,1,4,12,5,67};
        TreeNode root = null;
        for(int num : nums){
            root = insert(root, num);
        }
        inprint(root);
    }
    public void inprint(TreeNode root){
        if(root != null){
            inprint(root.left);
            System.out.println(root.val);
            inprint(root.right);
        }
    }

    public TreeNode insert(TreeNode root,int i){
        if(root == null){
            return new TreeNode(i);
        }
        if(root.val >= i){
            root.left = insert(root.left, i);
        }
        else{
            root.right = insert(root.right, i);
        }
        return root;
    }
}
