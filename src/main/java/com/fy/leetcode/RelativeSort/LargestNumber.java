package com.fy.leetcode.RelativeSort;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Classname LargestNumber
 * @Description TODO
 * @Date 2022/4/16 16:21
 * @Created by fy
 */
public class LargestNumber {
    public String largestNumber(int[] nums) {
        int len = nums.length;
        PriorityQueue<String> priorityQueue = new PriorityQueue<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o1 + o2).compareTo(o2 + o1);
            }
        });
        for(int num : nums){
            priorityQueue.add(String.valueOf(num));
        }
        StringBuilder sb = new StringBuilder();
        while (!priorityQueue.isEmpty()){
            sb.append(priorityQueue.poll());
        }
        if(sb.toString().charAt(0) == '0'){
            return "0";
        }
        return sb.toString();
    }
}
