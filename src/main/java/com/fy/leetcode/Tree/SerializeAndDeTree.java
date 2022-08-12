package com.fy.leetcode.Tree;

import com.fy.leetcode.Utils.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Classname SerializeAndDeTree
 * @Description TODO
 * @Date 2022/4/18 13:23
 * @Created by fy
 */
public class SerializeAndDeTree {
    List<String> list =  new ArrayList<>();;
    int index = 0;


    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        for(String ele : list){
            sb.append(ele).append("_");
        }
        list.clear();
        return sb.substring(0,sb.length() - 1).toString();
    }

    private void  dfs(TreeNode root){
        if(root == null){
            list.add("#");
            return;
        }
        list.add(String.valueOf(root.val));
        dfs(root.left);
        dfs(root.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] strs = data.split("_");
        for(String ele : strs){
            list.add(ele);
        }
        TreeNode root = deserialize();
        index = 0;
        list.clear();
        return root;
    }

    private TreeNode deserialize(){
        if("#".equals(list.get(index))){
            index++;
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(list.get(index)));
        index++;
        root.left = deserialize();
        root.right = deserialize();
        return root;
    }
}
