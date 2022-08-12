package com.fy.leetcode.Recursion;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname LongestPath
 * @Description TODO
 * @Date 2022/4/17 11:34
 * @Created by fy
 */

/*
* ����һ�� ������һ����ͨ�������޻�ͼ�������ڵ��ǽڵ� 0 ��������ɱ�Ŵ� 0 �� n - 1 �� n ���ڵ���ɡ����±�� 0 ��ʼ������Ϊ n ������ parent ����ʾ����������� parent[i] �ǽڵ� i �ĸ��ڵ㣬���ڽڵ� 0 �Ǹ��ڵ㣬���� parent[0] == -1 ��

�����һ���ַ��� s ������Ҳ�� n ������ s[i] ��ʾ������ڵ� i ���ַ���

�����ҳ�·��������һ�����ڽڵ㶼û�з��䵽��ͬ�ַ��� �·�� �������ظ�·���ĳ��ȡ�

��Դ�����ۣ�LeetCode��
���ӣ�https://leetcode-cn.com/problems/longest-path-with-different-adjacent-characters
����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
* */
public class LongestPath {


    int res = 1;
    public int longestPath(int[] parent, String s) {
        List<List<Integer>> g = new ArrayList<>();
        for(int i = 0; i < parent.length; i++){
            g.add(new ArrayList<>());
        }
        int root = 0;
        for(int i = 0; i < parent.length; i++){
           if(parent[i] == -1){
               root = i;
           }
           else{
               g.get(parent[i]).add(i);
           }
       }
        dfs(root, g, s);
        return res;
    }

    private int dfs(int root,List<List<Integer>> g,String s){
        int max1 = 0;
        int max2 = 0;
        List<Integer> sons = g.get(root);
        for(int son : sons){
            int d = dfs(son, g, s);
            if(s.charAt(son) == s.charAt(root)){
                continue;
            }
            if(d > max1){
                max2 = max1;
                max1 = d;
            }
            else if(d > max2){
                max2 = d;
            }
            res = Math.max(res, max1 + max2 + 1);
        }
        return max1 + 1;
    }
}
