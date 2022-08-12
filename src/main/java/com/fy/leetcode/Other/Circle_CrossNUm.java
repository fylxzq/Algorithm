package com.fy.leetcode.Other;

import java.util.Map;

/**
 * @Classname Circle_CrossNUm
 * @Description TODO
 * @Date 2021/8/8 19:26
 * @Created by fy
 */
public class Circle_CrossNUm {
    public void get_CrossNum(int[][] data){
        int len = data.length;//圆的个数
        for(int i = 0;i < len; ++i){
            int num = 0;
            int x = data[i][0];
            int y = data[i][1];
            int r = data[i][2];
            int x_length = Math.abs(x);
            int y_length = Math.abs(y);
            if(x*x + y*y == r*r){//圆与原点相交，则必有三个
                System.out.println(3);
            }
            else{
                if(x_length > r){
                    num += 0;
                }else if(x_length == r ){
                    num += 1;
                }
                else {
                    num += 2;
                }
                if(y_length > r){
                    num += 0;
                }else if(y_length == r ){
                    num += 1;
                }
                else {
                    num += 2;
                }
            }
            System.out.println(num);
        }
    }
}
