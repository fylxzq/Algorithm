package com.fy.leetcode.Hash;

import java.util.*;

/**
 * @Classname LFUCache
 * @Description TODO
 * @Date 2022/3/7 8:33
 * @Created by fy
 */
public class LFUCache {
    public static void main(String[] args) {
        LFUCache lfuCache = new LFUCache(2);
        lfuCache.put(1, 1);
        lfuCache.put(2, 2);
        lfuCache.get(1);
        lfuCache.put(3, 3);
        lfuCache.get(2);lfuCache.get(3);
        lfuCache.put(4, 4);
        lfuCache.get(1);
        lfuCache.get(3);
        lfuCache.get(4);
    }
    private Map<Integer,DNode> keyTable;
    private Map<Integer,DoubleLink> freqTable;
    private int minFreq;
    private int capacity;
    public LFUCache(int capacity) {
        minFreq = 1;
        this.capacity = capacity;
        keyTable = new HashMap<>();
        freqTable = new HashMap<>();
    }

    public int get(int key) {
        if(capacity == 0){
            return -1;
        }
        if( !keyTable.containsKey(key) ){
            return -1;
        }
        DNode node = keyTable.get(key);
        int freq = node.freq;
        DoubleLink doubleLink = freqTable.get(freq);
        doubleLink.remove(node);
        if(doubleLink.size == 0){
            freqTable.remove(freq);
            if(minFreq == freq){
                minFreq += 1;
            }
        }
        node.freq++;
        DoubleLink nextDoubleLink = freqTable.getOrDefault(freq + 1, new DoubleLink());
        nextDoubleLink.insertHead(node);
        freqTable.put(freq + 1, nextDoubleLink);
        return node.val;
    }

    public void put(int key, int value) {
        if(capacity == 0){
            return;
        }
        if( !keyTable.containsKey(key)){
            if(keyTable.size() == capacity){
                DoubleLink minLink = freqTable.get(minFreq);
                DNode node = minLink.removeTail();
                keyTable.remove(node.key);
                if(minLink.size == 0){
                    freqTable.remove(minFreq);
                }
            }
            DoubleLink link = freqTable.getOrDefault(1, new DoubleLink());
            DNode newNode = new DNode(value, key, 1);
            link.insertHead(newNode);
            freqTable.put(1, link);
            keyTable.put(key, newNode);
            minFreq = 1;
        }
        else{
            DNode node = keyTable.get(key);
            int freq = node.freq;
            node.val = value;
            DoubleLink doubleLink = freqTable.get(freq);
            doubleLink.remove(node);
            if(doubleLink.size == 0){
                freqTable.remove(freq);
                if(minFreq == freq){
                    minFreq += 1;
                }
            }
            node.freq++;
            DoubleLink nextDoubleLink = freqTable.getOrDefault(freq + 1, new DoubleLink());
            nextDoubleLink.insertHead(node);
            freqTable.put(freq + 1, nextDoubleLink);
        }
    }

}

class DNode{
    int val;
    int key;
    int freq;
    DNode pre;
    DNode next;

    public DNode(int val, int key, int freq) {
        this.val = val;
        this.key = key;
        this.freq = freq;
    }
}

class DoubleLink{
    DNode head;
    DNode tail;
    int size;

    public DoubleLink() {
        head = new DNode(-1, -1, -1);
        tail = new DNode(-1, -1, -1);
        head.next = tail;
        tail.pre = head;
        size++;
    }

    public void remove(DNode node){
        node.pre.next = node.next;
        node.next.pre = node.pre;
        node.next = null;
        node.pre = null;
        size--;
    }

    public void insertHead(DNode node){
        node.next = head.next;
        node.next.pre = node;
        head.next = node;
        node.pre = head;
        size++;
    }

    public DNode removeTail(){
        DNode node = tail.pre;
        remove(node);
        return node;
    }
}