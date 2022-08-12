package com.fy.leetcode;

import com.fy.leetcode.Utils.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Classname MinPriorityQueue
 * @Description TODO
 * @Date 2021/12/27 22:00
 * @Created by fy
 */


public class TestMinPriorityQueue{
    public static void main(String[] args) {
        MinPriorityQueue<ListNode> queue = new MinPriorityQueue<ListNode>(10, (node1, node2) -> {
            return node1.val - node2.val;
        });
        PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>((node1,node2) -> node1.val - node2.val);
        queue.insert(new ListNode(2));
        queue.insert(new ListNode(1));
        System.out.println(queue.delMin().val);


    }
}

//小顶堆
class MinPriorityQueue<T> {
    private Object[] items;
    private int size;
    private Comparator<T> comp;

    public MinPriorityQueue(int capacity, Comparator<T> comp) {
        this.size = 0;
        this.comp = comp;
        this.items = new Object[capacity + 1];
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    //:交换堆中i索引和j索引处的值
    private void exchange(int i, int j) {
        Object temp = items[i];
        items[i] = items[j];
        items[j] = temp;
    }

    //判断堆中索引i处的元素是否小于索引j处的元素
    private boolean less(int i, int j) {
        return comp.compare((T)items[i],(T)items[j]) < 0;
    }

    public void insert(ListNode t){
        items[++size] = t;
        swim(size);
    }

    private void swim(int k){
        while (k > 1){
            if(less(k , k / 2)){
                exchange(k, k / 2);
            }
            k = k / 2;
        }
    }

    public T delMin(){
        Object min = items[1];
        exchange(1, size);
        items[size] = null;
        size -- ;
        sink(1);
        return (T) min;
    }

    public void sink(int k){
        while (2 * k <= size){
            int min = 2 * k;
            if(min + 1 <= size){
                if(!less(min, min+1)){
                    min = min + 1;
                }
            }
            if(less(k, min)){
                break;
            }
            exchange(k , min);
            k = min;

        }
    }


}

