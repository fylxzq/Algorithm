package com.fy.leetcode.Strs;


import org.junit.Test;

/**
 * @Classname Zconvert
 * @Description TODO
 * @Date 2021/7/27 9:12
 * @Created by fy
 */
public class Zconvert {

    public String convert(String s, int numRows){
        int gap_num = 2 * numRows - 2;//ͬһ��λ�õ���ĸ����ľ���
        StringBuilder sb  = new StringBuilder();
        int i = 0;
        int len = s.length();
        if(numRows == 1){
            return s;
        }
        while (i < numRows){
            int j = 0;//jһ��Ҫ��0��ʼ
            while (j + i < len){
                sb.append(s.charAt(j+i));
                if( i!=0 && i!= numRows - 1 && j  + gap_num -1 < len){
                    sb.append(s.charAt(gap_num + j - i));
                }
                j += gap_num;
            }
            ++i;
        }
        return sb.toString();
    }
}
