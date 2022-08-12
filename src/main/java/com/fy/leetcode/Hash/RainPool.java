package com.fy.leetcode.Hash;

import java.util.HashMap;
import java.util.TreeSet;

/**
 * @Classname RainPool
 * @Description TODO
 * @Date 2021/8/5 14:07
 * @Created by fy
 */
public class RainPool {
    public int[] avoidFlood(int[] rains){
        int len = rains.length;
        int[] ans = new int[len];
        HashMap<Integer,Integer> rainMap = new HashMap<Integer, Integer>();
        TreeSet<Integer> sunny_date = new TreeSet<Integer>();//��¼���������
        for(int i = 0; i < len; ++i ){
            if(rains[i] == 0){
                sunny_date.add(i);//������������ӵ�treeset��
                ans[i] = 1;
                continue;
            }
            else{
                ans[i] = -1;
            }
            if( !rainMap.containsKey(rains[i])){
                rainMap.put(rains[i],i);
            }
            else{
                Integer t = sunny_date.higher(rainMap.get(rains[i]));
                //������һ�����ҵ��ϴ�������������Ժ����������һ������
                if(t == null){
                    return new int[0];//���û�����죬�ᷢ����ˮ
                }
                else{
                    ans[t] = rains[i];//�ҵ������죬����������ˮ
                }
                sunny_date.remove(t);
                rainMap.put(rains[i],i);
            }
        }
        return ans;
    }
}
