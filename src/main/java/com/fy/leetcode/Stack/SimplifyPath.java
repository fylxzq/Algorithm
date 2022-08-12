package com.fy.leetcode.Stack;

import org.junit.Test;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @Classname SimplifyPath
 * @Description TODO
 * @Date 2022/5/12 19:47
 * @Created by fy
 */
public class SimplifyPath {

    @Test
    public void  test(){
        System.out.println(Arrays.toString("/home/".split("/",-1)));
    }
    public String simplifyPath(String path) {
        Deque<String> deque = new LinkedList<>();
        char[] chars = path.toCharArray();
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < chars.length){
            if ((chars[i] == '/'|| i == chars.length - 1) && sb.length() != 0){
                deque.add(sb.toString());
                sb = new StringBuilder();
            }
            else if(chars[i] == '.'){
                if(i + 1 < chars.length && chars[i] == '.'){
                    if(!deque.isEmpty()){
                        deque.pop();
                    }
                    i++;
                }
            }
            else if(Character.isAlphabetic(chars[i])){
                sb.append(chars[i]);
            }
            i++;
        }
        sb = new StringBuilder();
        while (!deque.isEmpty()){
            sb.append("/");
            sb.append(deque.pollLast());
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }
}
