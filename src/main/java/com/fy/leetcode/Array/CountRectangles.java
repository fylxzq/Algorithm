package com.fy.leetcode.Array;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.CookieHandler;
import java.util.*;

/**
 * @Classname CountRectangles
 * @Description TODO
 * @Date 2022/4/24 10:47
 * @Created by fy
 */
public class CountRectangles {
    @Test
    public void test() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s;
        while ((s = br.readLine()) != null){
            System.out.println(s);
        }
    }

    public int[] countRectangles(int[][] rectangles, int[][] points) {
        Map<Integer, List<Integer>> highMap = new HashMap<>();
        int maxHigh = 100;
        for (int[] rectangle : rectangles) {
            List<Integer> list = highMap.getOrDefault(rectangle[1], new ArrayList<Integer>());
            list.add(rectangle[0]);
            maxHigh = Math.max(maxHigh, rectangle[1]);
        }
        for (Map.Entry<Integer, List<Integer>> entry : highMap.entrySet()) {
            Collections.sort(entry.getValue());
        }
        int[] res = new int[points.length];
        for (int i = 0; i < points.length; i++) {
           int row = points[i][0];
           int col = points[i][1];
           int count = 0;
           for(int j = maxHigh; j >= col;j--){
               if(highMap.containsKey(j)){
                   int tmpCount = binarySearch(highMap.get(j), row);
                   count += tmpCount;
               }
           }
           res[i] = count;
        }
        return res;
    }
    private int binarySearch(List<Integer> list,int target){
        int size = list.size();
        int low = 0;
        int high = size - 1;
        while (low < high){
            int mid = (high - low) / 2 + low;
            if(list.get(mid) < target){
                low = mid + 1;
            }
            else{
                high = mid;
            }
        }
        return list.get(high) >= target ? size - high : 0;
    }
}
