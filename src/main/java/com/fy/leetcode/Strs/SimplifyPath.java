package com.fy.leetcode.Strs;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @Classname SimplifyPath
 * @Description TODO
 * @Date 2022/7/6 21:35
 * @Created by fy
 */
public class SimplifyPath {
    public String simplifyPath(String path) {
        String[] dirs = path.split("/");
        Deque<String> deque = new LinkedList<>();
        for(String dir : dirs){
            if("..".equals(dir) && !deque.isEmpty()){
                deque.pollLast();
            }
            else if(dir.length() != 0 && !".".equals(dir)){
                deque.offerLast(dir);
            }
        }
        StringBuilder sb = new StringBuilder();
        if(deque.isEmpty()) sb.append("/");
        while ( !deque.isEmpty() ){
            sb.append("/");
            sb.append(deque.pollFirst());
        }
        return sb.toString();
    }
}
