package com.fy.leetcode.Strs;

/**
 * @Classname DigitSum
 * @Description TODO
 * @Date 2022/4/17 10:33
 * @Created by fy
 */
public class DigitSum {
    public String digitSum(String s, int k) {
        int len = s.length();
        if(len <= k){
            return s;
        }
        while (s.length() > k){
            StringBuilder sb = new StringBuilder();
            int i = 0;
            while (i < s.length()){
                int j = (i + k - 1 >= s.length()) ? s.length() - 1 : i + k - 1;
                sb.append(getSum(s, i, j));
                i = j + 1;
            }
            s = sb.toString();
        }
        return s;
    }

    private int getSum(String s,int begin,int end){
        int res = 0;
        for(int i = begin;i <= end; i++){
            res += (s.charAt(i) - '0');
        }
        return res;
    }
}
