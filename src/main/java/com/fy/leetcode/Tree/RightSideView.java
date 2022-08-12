package com.fy.leetcode.Tree;

import com.fy.leetcode.Utils.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @Classname RightSideView
 * @Description TODO
 * @Date 2022/1/3 21:58
 * @Created by fy
 */
public class RightSideView {
    public List<Integer> rightSideView(TreeNode root){
        List<Integer> list  = new ArrayList<>();
        Deque<TreeNode> deque = new LinkedList<>();
        if(root != null){
            deque.add(root);
        }
        while (!deque.isEmpty()){
            int size = deque.size();
            for(int i = 0; i < size; ++i){
                TreeNode tmpnode = deque.pollFirst();
                if(i == size - 1){
                    list.add(tmpnode.val);
                }
                if(tmpnode.left != null){
                    deque.add(tmpnode.left);
                }
                if(tmpnode.right != null){
                    deque.add(tmpnode.right);
                }
            }
        }
        return list;
    }
}
