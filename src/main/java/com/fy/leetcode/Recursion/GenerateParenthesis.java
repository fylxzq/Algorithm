package com.fy.leetcode.Recursion;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @Classname GenerateParenthesis
 * @Description TODO
 * @Date 2022/1/17 18:12
 * @Created by fy
 */
public class GenerateParenthesis {
    List<String> rst = new ArrayList<>();
//    @Test
//    public void test(){
//        generateParenthesis(3);
//    }
    public List<String> generateParenthesis(int n) {
        char[] arr = new char[2*n];
        dfs(arr, 0, n, n);
        return rst;
    }

    public void dfs(char[] arr,int loc,int left,int right){
        if(left > right){
            return;
        }
        if(left == 0 && right == 0){
            char[] newarr = Arrays.copyOf(arr , arr.length);
            rst.add(String.valueOf(newarr));
        }
        if(left > 0){
            arr[loc] = '(';
            dfs(arr, loc+1, left-1, right);
        }
        if(right > 0){
            arr[loc] = ')';
            dfs(arr, loc+1, left, right-1);
        }
    }
}
