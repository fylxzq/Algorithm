package com.fy.leetcode.Hash;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @Classname LRUCache
 * @Description TODO
 * @Date 2021/8/7 8:49
 * @Created by fy
 */
public class LRUCache {
    class DLink{
        DLink pre = null;
        DLink next = null;
        int key; //定义key的目的是当缓存满的时候要删除双链表的一个元素，
        // 同时要删除哈希表里这个元素key对应的元素
        int value;

        public DLink(int key, int value) {
            this.key = key;
            this.value = value;
        }

        public DLink() {
        }
    }
    private int size;
    private int capacity;
    private Map<Integer,DLink> map = new HashMap<Integer, DLink>();
    //哈希表示用来定位元素在双链表的指针位置，保证查找的时间复杂度为o(1)
    private DLink head;
    private DLink tail;
    public LRUCache(int capacity) {//初始化缓存空间
        size = 0;
        this.capacity = capacity;
        head = new DLink();
        tail = new DLink();
        head.next = tail;
        tail.pre = head;

    }

   public int get(int key){
        if(!map.containsKey(key)){
            return -1;
        }
        else{
            moveToTail(map.get(key));
            return map.get(key).value;
        }
   }

   public void put(int key,int value){
        if(!map.containsKey(key)){//如果缓存中没有要添加的元素，则向缓存中添加该元素
            DLink new_node = new DLink(key, value);
            map.put(key,  new_node);
            if(size == capacity){//缓存满了，先删除后添加
                DLink res = removeHead();
                map.remove(res.key);//删除哈希表对应的一个元素
                addElement(new_node);
            }
            else{
                addElement(new_node);
                size++;
            }
        }
        else{
            map.get(key).value = value;
            moveToTail(map.get(key));
        }
   }

   public void addElement(DLink new_node){//将新元素插入到链表尾部
        DLink pre = tail.pre;
        pre.next = new_node;
        new_node.pre = pre;
        new_node.next = tail;
        tail.pre = new_node;
   }
   public void removeElement(DLink old_node){//删除一个要删除的节点
        old_node.pre.next = old_node.next;
        old_node.next.pre = old_node.pre;
   }
   public void moveToTail(DLink node){//
        removeElement(node);
        addElement(node);
   }

   public DLink removeHead(){//缓存满的时候要删除最早使用的元素，这里定义的是在链表头部的位置
        DLink res = head.next;
        removeElement(res);
        return res;
   }

}
