package com.fy.leetcode.Tree;

import com.fy.leetcode.Utils.TreeNode;
import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Classname IsCompleteTree
 * @Description TODO
 * @Date 2022/3/2 8:50
 * @Created by fy
 */
public class IsCompleteTree {


    public boolean isCompleteTree(TreeNode root) {
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offerLast(root);
        while (!deque.isEmpty()){
            int size = deque.size();
            for (int i = 0; i < size;++i){
                TreeNode tmp = deque.pollFirst();
                if(tmp == null){
                    while (!deque.isEmpty() && deque.pollFirst() != null){
                        return false;
                    }
                    return true;
                }
                deque.offerLast(tmp.left);
                deque.offerLast(tmp.right);
            }
        }
        return true;
    }


}
