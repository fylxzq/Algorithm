package com.fy.leetcode.Array;

import org.junit.Test;

import java.security.interfaces.RSAKey;

/**
 * @Classname FindDiagonalOrder
 * @Description TODO
 * @Date 2022/3/4 11:05
 * @Created by fy
 */
public class FindDiagonalOrder {
    @Test
    public void test() {
        int[][] mat = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        findDiagonalOrder(mat);
    }
    public int[] findDiagonalOrder(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[] res = new int[m * n];
        int count = 0;
        int i = 0;
        int j = 0;
        while (count < m * n){
            res[count] = mat[i][j];
            if((i + j) % 2 == 0){
                if(i - 1 >= 0 && j + 1 < n){
                    i--;
                    j++;
                }
                else if(j + 1 == n){
                    i++;
                }
                else {
                    j++;
                }
            }
            else{
                if(i + 1 < m && j - 1 >= 0){
                    i--;
                    j++;
                }
                else if(i + 1 == m){
                    j++;
                }
                else {
                    i++;
                }
            }
            count++;
        }
       return res;
    }

}
