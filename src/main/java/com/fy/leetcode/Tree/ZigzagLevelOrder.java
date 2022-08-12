package com.fy.leetcode.Tree;

import com.fy.leetcode.Utils.TreeNode;

import java.util.*;

/**
 * @Classname ZigzagLevelOrder
 * @Description TODO
 * @Date 2021/8/25 14:19
 * @Created by fy
 */
public class ZigzagLevelOrder {
    public List<List<Integer>> zigzaglevelOrder(TreeNode root){
        List<List<Integer>> rst = new ArrayList<List<Integer>>();
        if(root == null){
            return rst;
        }
        Deque<TreeNode> deque = new LinkedList<TreeNode>();
        boolean move_flag = false;//false代表从左往右，true代表从右往左
        deque.offerLast(root);
        while ( !deque.isEmpty()){
            int cur_size = deque.size();
            List<Integer> level_list = new ArrayList<Integer>();
            if( !move_flag ){
                for(int i=0;i < cur_size; ++i){
                    TreeNode node = deque.pollFirst();
                    level_list.add(node.val);
                    if(node.left != null){
                        deque.offerLast(node.left);
                    }
                    if(node.right != null){
                        deque.offerLast(node.right);
                    }
                }
                rst.add(level_list);
                move_flag = true;
                continue;
            }
            if(move_flag){
                for(int i=0;i < cur_size; ++i){
                    TreeNode node = deque.pollLast();
                    level_list.add(node.val);
                    if(node.right != null){
                        deque.offerFirst(node.right);
                    }
                    if(node.left != null){
                        deque.offerFirst(node.left);
                    }
                }
                move_flag = false;
                rst.add(level_list);
            }

        }
    return rst;

    }

    public List<List<Integer>> levelOrder(TreeNode root){
        List<List<Integer>> rst = new ArrayList<List<Integer>>();
        if(root == null){
            return rst;
        }

        Queue<TreeNode> queue = new ArrayDeque<TreeNode>();
        queue.offer(root);
        while ( !queue.isEmpty() ){
            List<Integer> level_values = new ArrayList<Integer>();
            int size = queue.size();
            for(int i = 0; i < size; ++i){
                TreeNode tmpnode = queue.poll();
                level_values.add(tmpnode.val);
                if(tmpnode.left != null){
                    queue.offer(tmpnode.left);
                }
                if(tmpnode.right != null){
                    queue.offer(tmpnode.right);
                }
            }
            rst.add(level_values);

        }
        return rst;
    }
}

