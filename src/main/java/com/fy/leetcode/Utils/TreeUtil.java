package com.fy.leetcode.Utils;

/**
 * @Classname BuildTree
 * @Description TODO
 * @Date 2022/1/10 21:58
 * @Created by fy
 */
public class TreeUtil {

    public static void PrePrintTree(TreeNode root){
        if(root == null){
            return;
        }
        System.out.print(root.val + ",");
        PrePrintTree(root.left);
        PrePrintTree(root.right);
    }

    public static TreeNode buildTree(int[] preorder,int[] inorder){
        int len1 = preorder.length;
        int len2 = preorder.length;
        return prebuildTree(preorder, 0, len1-1, inorder, 0,len2-1);
    }
    public static TreeNode prebuildTree(int[] preorder,int premin,int premax,int[] inorder,int inmin,int inmax){
        if(premin > premax){
            return null;
        }
        TreeNode tmonode = new TreeNode(preorder[premin]);
        int inrootindex = findRoot(tmonode.val, inorder, inmin, inmax);
        int leftnum = inrootindex - inmin;

        tmonode.left = prebuildTree(preorder, premin + 1, premin + leftnum,inorder,inmin,inrootindex-1);
        tmonode.right = prebuildTree(preorder, premin+leftnum+1, premax, inorder, inrootindex+1, inmax);
        return tmonode;
    }


    public static TreeNode postBuildTree(int[] inorder,int[] postorder,int inmin,int inmax,int postmin,int postmax){
        if(inmin > inmax){
            return null;
        }
        TreeNode root = new TreeNode(postorder[postmax]);
        int index = findRoot(postorder[postmax],inorder,inmin, inmax);
        int left_num = index - inmin;
        int right_num = inmax - index;
        root.left = postBuildTree(inorder, postorder, inmin, inmin + left_num - 1, postmin, postmin +  + left_num - 1);
        root.right = postBuildTree(inorder, postorder, inmin + left_num + 1, inmax, postmin +  + left_num, postmax - 1);
        return root;
    }
    public static int findRoot(int val,int[] nums,int left,int right){
        for(int i = left;i <= right;++i){
            if(nums[i] == val){
                return i;
            }
        }
        return 0;
    }

}
