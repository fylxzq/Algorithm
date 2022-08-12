package com.fy.leetcode.Array;

import org.junit.Test;

/**
 * @Classname Find_Ball
 * @Description TODO
 * @Date 2021/8/2 8:42
 * @Created by fy
 */
public class Find_Ball {



    public int find_ball(int N, int X, int K, int[][] seq){
        int len = seq.length;
        int tmp_point = X;
        for(int i = 0; i< len; ++i){
            if(seq[i][0] == tmp_point){
                tmp_point = seq[i][1];
                continue;//必须要continue
            }
            if(seq[i][1] == tmp_point){
                tmp_point = seq[i][0];
                continue;//必须要continue
            }
        }
        return tmp_point;
    }
}
