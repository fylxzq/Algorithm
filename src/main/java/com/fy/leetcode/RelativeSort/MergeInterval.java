package com.fy.leetcode.RelativeSort;

import org.junit.Test;

import java.util.*;

/**
 * @Classname MergeInterval
 * @Description TODO
 * @Date 2022/1/5 17:25
 * @Created by fy
 */
public class MergeInterval {
    @Test
    public void test(){
        int[][] intervals = new int[][]{{15,18},{1,6},{1,3},{8,10}};
        Arrays.sort(intervals, Comparator.comparing((int[] arr) -> -arr[0]).thenComparing((int[] arr) -> arr[1]));
//        merge(intervals);
        for(int[] interval : intervals){
            System.out.print(Arrays.toString(interval) + " ");
        }
    }
    public int[][] merge(int[][] intervals) {
       Arrays.sort(intervals, (o1,o2) -> {
           return o1[0] - o2[0];
       });
       List<int[]> rst = new ArrayList<>();
       int[] oneinterval = intervals[0];
       int len = intervals.length;
       for(int i = 1; i < len;++i){
           int[] tmpinterval = intervals[i];
           if(tmpinterval[0] <= oneinterval[1] ){
               oneinterval[1] = Math.max(oneinterval[1],tmpinterval[1]);
           }
           else{
               rst.add(oneinterval);
               oneinterval = tmpinterval;
           }
       }
       rst.add(oneinterval);
       return rst.toArray(new int[rst.size()][2]);
    }


}
