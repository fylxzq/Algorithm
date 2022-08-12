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
        int key; //����key��Ŀ���ǵ���������ʱ��Ҫɾ��˫�����һ��Ԫ�أ�
        // ͬʱҪɾ����ϣ�������Ԫ��key��Ӧ��Ԫ��
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
    //��ϣ��ʾ������λԪ����˫�����ָ��λ�ã���֤���ҵ�ʱ�临�Ӷ�Ϊo(1)
    private DLink head;
    private DLink tail;
    public LRUCache(int capacity) {//��ʼ������ռ�
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
        if(!map.containsKey(key)){//���������û��Ҫ��ӵ�Ԫ�أ����򻺴�����Ӹ�Ԫ��
            DLink new_node = new DLink(key, value);
            map.put(key,  new_node);
            if(size == capacity){//�������ˣ���ɾ�������
                DLink res = removeHead();
                map.remove(res.key);//ɾ����ϣ���Ӧ��һ��Ԫ��
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

   public void addElement(DLink new_node){//����Ԫ�ز��뵽����β��
        DLink pre = tail.pre;
        pre.next = new_node;
        new_node.pre = pre;
        new_node.next = tail;
        tail.pre = new_node;
   }
   public void removeElement(DLink old_node){//ɾ��һ��Ҫɾ���Ľڵ�
        old_node.pre.next = old_node.next;
        old_node.next.pre = old_node.pre;
   }
   public void moveToTail(DLink node){//
        removeElement(node);
        addElement(node);
   }

   public DLink removeHead(){//��������ʱ��Ҫɾ������ʹ�õ�Ԫ�أ����ﶨ�����������ͷ����λ��
        DLink res = head.next;
        removeElement(res);
        return res;
   }

}
