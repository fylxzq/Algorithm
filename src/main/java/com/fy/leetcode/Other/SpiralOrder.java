package com.fy.leetcode.Other;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Classname SpiralOrder
 * @Description TODO
 * @Date 2021/12/28 10:45
 * @Created by fy
 */
public class SpiralOrder {
    @Test

    public void test(){
        int[][] matrix = {{1,2,3,},{4,5,6},{7,8,9}};
        System.out.println(spiralOrder(matrix));
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> rst = new ArrayList<>();
        int row = matrix.length;
        int col = matrix[0].length;
        int rightlimit = col - 1,leftlimit = 0,downlimit = row - 1,uplimit = 1;
        int i = 0;
        int j = -1;
        int  flag = 0;
        while (rst.size() != row * col){
            if(flag == 0 && j + 1 <= rightlimit){
                j = j + 1;
                if(j == rightlimit){
                    rightlimit -= 1;
                    flag = 1;
                }
            }
            else if(flag == 1 && i + 1 <= downlimit){
                i = i + 1;
                if(i  == downlimit){
                    downlimit -= 1;
                    flag = 2;
                }

            }
            else if(flag == 2 && j - 1 >= leftlimit){
                j = j - 1;
                if(j == leftlimit){
                    leftlimit += 1;
                    flag = 3;
                }
            }
            else if(flag == 3 && i - 1 >= uplimit){
                i = i - 1;
                if(i == uplimit){
                    uplimit += 1;
                    flag = 0;
                }
            }
            rst.add(matrix[i][j]);
        }
        return rst;
    }
}


