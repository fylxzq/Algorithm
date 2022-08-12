package com.fy.leetcode.Strs;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @Classname Tencent424OneStrsCol
 * @Description TODO
 * @Date 2022/4/24 20:02
 * @Created by fy
 */
public class Tencent424OneStrsCol {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());
        String line;
        String[] strs = new String[n];
        int count = 0;
        for (int i = 0; i < n; i ++){
            strs[i] = br.readLine();
        }
        int strLength = strs[0].length();
        int[] res = new int[strLength];
        for(int i = 0; i < strLength; i++){
            int oneres = 0;
            for(int j = 0; j < n; j++){
                oneres = oneres * 10 + (strs[j].charAt(i) - '0');
            }
            res[i] = oneres;
            oneres = 0;
        }
        Arrays.sort(res);
        for(int i = 0; i < strLength;i++){
            if(i == strLength - 1){
                System.out.print(res[i]);
            }
            else{
                System.out.print(res[i] + " ");
            }
        }
    }
}
