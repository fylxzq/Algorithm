package com.fy.leetcode.LinkedList;

import com.fy.leetcode.Utils.LinkListUtil;
import com.fy.leetcode.Utils.ListNode;
import org.junit.Test;

import java.util.Arrays;

/**
 * @Classname SpiralMatrix
 * @Description TODO
 * @Date 2022/7/3 10:41
 * @Created by fy
 */
public class SpiralMatrix {
    @Test
    public void test(){
        ListNode linkList = LinkListUtil.createLinkList(new int[]{3, 0, 2, 6, 8, 1, 7, 9, 4, 2, 5, 5, 0});
        spiralMatrix(3, 5, linkList);
    }
    int[][] directions = {{0,1},{1,0},{-1,0},{0,-1}};//сробвСио
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int[][] res = new int[m][n];
        for(int i = 0; i < m; i++){
            Arrays.fill(res[i],1001);
        }
        int i = 0, j = 0;
        int curDirection = 0;
        ListNode p = head;
        for(int k = 0; k < m * n; k++){
            int curVal = p == null ? -1 : p.val;
            res[i][j] = curVal;
            int nexti = i + directions[curDirection][0];
            int nextj = j + directions[curDirection][1];
            if(nexti == m || nextj == n || nextj < 0 || nexti < 0 || res[nexti][nextj] != 1001){
                curDirection = (curDirection + 1) % 4;
            }
            i = i + directions[curDirection][0];
            j = j + directions[curDirection][1];
            p = p == null ? p : p.next;
        }
        return res;
    }
}
