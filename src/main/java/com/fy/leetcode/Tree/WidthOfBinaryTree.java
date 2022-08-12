package com.fy.leetcode.Tree;

import com.fy.leetcode.Utils.TreeNode;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @Classname WidthOfBinaryTree
 * @Description TODO
 * @Date 2022/3/3 11:07
 * @Created by fy
 */
public class WidthOfBinaryTree {
    int res = 0;
    Map<Integer,Integer> map = new HashMap<>();
    public int widthOfBinaryTree(TreeNode root) {
        dfs(root, 0,0);
        return res;
    }

    public void dfs(TreeNode root, int level,int index){
        if(root == null){
            return;
        }
        if( !map.containsKey(level) ){
            map.put(level, index);
        }
        else{
            res = Math.max(res, index - map.get(level) + 1);
        }
        dfs(root.left, level + 1, 2 * index + 1);
        dfs(root.right, level + 1, 2 * index + 2);
    }

}
