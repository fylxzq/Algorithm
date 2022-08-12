package com.fy.leetcode.Array;

/**
 * @Classname CalculateTax
 * @Description TODO
 * @Date 2022/6/12 10:31
 * @Created by fy
 */
public class CalculateTax {

    public double calculateTax(int[][] brackets, int income) {
        double res = 0.0;
        int len = brackets.length;
        for(int i = 0; i < len; i++){
            if(income > brackets[i][0]){
                int extra  = i - 1 == 0 ? brackets[i][0] - 0 : brackets[i][0] - brackets[i - 1][0];
                res += extra * (double) brackets[i][1] / 100;
            }
            else{
                int extra = i - 1 == 0 ? income - 0 : income - brackets[i - 1][0];
                res += extra * (double) brackets[i][1] / 100;
            }
        }
        return res;
    }
}
