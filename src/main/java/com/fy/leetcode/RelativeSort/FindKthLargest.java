package com.fy.leetcode.RelativeSort;

import com.fy.leetcode.Utils.ListNode;
import org.junit.Test;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Random;

/**
 * @Classname FindKthLargest
 * @Description TODO
 * @Date 2021/8/10 14:52
 * @Created by fy
 */

/*
* 这题主要是用到了快速排序中的partition思想*/

public class FindKthLargest {


    Random random = new Random();

    @Test
    public void test(){
        PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>((node1, node2) -> {
            return node2.val - node1.val;
        });
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        queue.add(node2);
        queue.add(node1);
        System.out.println(queue.poll().val);

    }
    public int quickSelect(int[] arr, int low ,int high,int index){
      int midde_index = partition(arr, low, high);
      if(midde_index == index){
          return arr[midde_index];
      }
      return midde_index < index ? randompartition(arr, midde_index, high) : partition(arr, low, midde_index);
    }

    public int randompartition(int[] arr,int low,int high){
       int randNum = random.nextInt(high - low + 1) + low;
       int tmpvalue = arr[randNum];
       arr[randNum] = arr[low];
       arr[low] = tmpvalue;
       return partition(arr, low,high );
    }

    public int partition(int[] arr,int low ,int high){
        int tmpvalue = arr[low];
        while (low < high) {
            while (low < high && arr[high] >= tmpvalue) {
                --high;
            }
            arr[low] = arr[high];
            while (low < high && arr[low] < tmpvalue) {
                ++low;
            }
            arr[high] = arr[low];
        }
        // 跳出循环时low和high相等,此时的low或high就是tmp的正确索引位置
        // 由原理部分可以很清楚的知道low位置的值并不是tmp,所以需要将tmp赋值给arr[low]
        arr[low] = tmpvalue;
        return low;

    }



    public int findKthLargest(int[] nums,int k){
        int len = nums.length;
        for(int i = len / 2 -1;i>=0;--i){
            adjustheap(nums, i,len );//构建大顶堆
        }
        System.out.println(Arrays.toString(nums));
        for(int i = 0;i < k - 1; ++i){
            nums[0] = nums[nums.length - i  - 1];
            adjustheap(nums,0,nums.length - i - 1);
        }
        return nums[0];
    }

    public void adjustheap(int[] arr,int k,int heapsize){
        int tmp = arr[k];
        int i = k;
        int j = 2*k+1;
        while (j < heapsize){
            if(j + 1 < heapsize && arr[j+1] > arr[j]){
                ++j;
            }
            if(arr[j] > tmp){
                arr[i] = arr[j];
                i = j;
                j = 2*i+1;
            }
            else{
                break;
            }
        }
        arr[i] = tmp;

    }

}
