package com.fy.leetcode.RelativeSort;

import java.util.PriorityQueue;

/**
 * @Classname MedianFinder
 * @Description TODO
 * @Date 2022/3/19 16:44
 * @Created by fy
 */
public class MedianFinder {

    public static void main(String[] args) {
//        MedianFinder medianFinder = new MedianFinder();
//        medianFinder.addNum(1);
//        medianFinder.addNum(2);
//        medianFinder.findMedian();
//        medianFinder.addNum(3);
//        medianFinder.findMedian();
    }
    private int size = 0;
    private PriorityQueue<Integer> minQueue;
    private PriorityQueue<Integer> maxQueue;
    public MedianFinder() {
        minQueue = new PriorityQueue<>(Integer::compare);//Ð¡¶¥¶Ñ
        maxQueue = new PriorityQueue<>((num1,num2) -> Integer.compare(num2, num1));//´ó¶¥¶Ñ
    }

    public void addNum(int num) {
       if(maxQueue.isEmpty() || num <= maxQueue.peek()){
           maxQueue.add(num);
           if(maxQueue.size() > minQueue.size() + 1){
               minQueue.add(maxQueue.poll());
           }
       }
       else{
           minQueue.add(num);
           if(minQueue.size() > maxQueue.size()){
               maxQueue.add(minQueue.poll());
           }
       }
    }

    public double findMedian() {
        if(maxQueue.size() > minQueue.size()){
            return maxQueue.peek();
        }
        return (maxQueue.peek() + minQueue.peek()) / 2.0;
    }
}
