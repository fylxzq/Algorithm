package com.fy.leetcode.Greedy;

/**
 * @Classname EatCandy_PDD
 * @Description TODO
 * @Date 2021/8/8 19:41
 * @Created by fy
 */
public class EatCandy_PDD {
    public int NumOfEatCandy(int n, int t, int c,int[] arr){//����arr��n���ǹ������
        if(c > n){
            return 0;
        }
        int rst = 0;
        int i = 0;//iָ���һ����ȴ���t���ǹ���һ������ʼֵΪ0;
        int j = 0;//����ָ��
        while (j < n){
            if(arr[j] > t){//��ȴ���t��iָ���һ���ǹ�
                j += 1;
                i = j;
            }
            else{
                if(j - i + 1 < c){
                    ++j;//û�дﵽ����c��
                }
                else{
                    rst += 1;//���ڵ���c��û����һ�����С�ڵ���t���ǹ�������ͼ�1
                    ++j;
                }
            }
        }
        return rst;

    }
}
