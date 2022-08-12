package com.fy.leetcode.Greedy;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @Classname ReviewOfMei
 * @Description TODO
 * @Date 2022/5/21 17:03
 * @Created by fy
 */
public class ReviewOfMei {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String line = sc.nextLine();
        String[] strArr = line.split(" ");

        int n = Integer.parseInt(s.split(" ")[0]);
        int m = Integer.parseInt(s.split(" ")[1]);
        long[] needtime = new long[n];
        for(int i = 0; i < needtime.length;i++){
            needtime[i] = Integer.parseInt(strArr[i]);
        }
        long[] days = new long[m];
        Arrays.sort(needtime);
        for(int i = needtime.length - 1; i >= 0; i--){
            long time = needtime[i];
            int minindex = 0;
            long minTime = days[0];
            for(int j = 0; j < m; j++){
                if(days[j] < minTime){
                    minindex = j;
                    minTime = days[j];
                }
            }
            days[minindex] += time;
        }
        long maxTime = days[0];
        for(int i = 0; i < m; i++){
            if(days[i] > maxTime){
                maxTime = days[i];
            }
        }
        System.out.println(maxTime);
    }
}
