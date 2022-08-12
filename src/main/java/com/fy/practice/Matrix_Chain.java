//矩阵链相乘
package com.fy.practice;
import org.junit.Test;
public class Matrix_Chain {
    @Test
    public void Test(){
        int[][] matrix = {{30,35},{35,15},{15,5},{5,10},{10,20},{20,25}};
        int len = matrix.length;
        int[][] record = new int[len][len];
        int rst = getMinNum(matrix,record);
        printBrackets(0,len-1,record);
        System.out.println(rst);
    }



    public int getMinNum(int[][] matrix,int[][] record){
        int len = matrix.length;
        int[][] dp = new int[len][len];//dp[1][n]代表A1到An乘起来的最小值
        for (int i=0;i<len;++i){
            dp[i][i] = 0;
        }
        for(int l=2;l<=len;++l){//长度的循环要放在前面，不然有问题，例如计算dp[2][4]必须先知道dp[3][4]
            for(int i=0;i<=(len-l);++i){//注意这里的i的取值，是len减去前面的长度循环值
                int j = l+i-1;
                dp[i][j] = Integer.MAX_VALUE;//设置最大值
                for(int k=i;k<j;++k){
                    int tmpvalue = dp[i][k] + dp[k+1][j] +
                            matrix[i][0]*matrix[k][1]*matrix[j][1];//状态转移公式
                    System.out.println(i+"--"+k+"---"+j+"---"+tmpvalue);
                    if(tmpvalue<dp[i][j]){
                        dp[i][j] = tmpvalue;
                        record[i][j] = k;//记录截断的位置
                    }
                }
            }
        }
        return dp[0][len-1];
    }

    //打印括号，从哪里截断
    public void printBrackets(int i,int j,int[][] record){
        if(record[i][j] !=0){
            System.out.println(i+"----"+record[i][j]);
            System.out.println(record[i][j]+"----"+j);
            printBrackets(i,record[i][j],record);
            printBrackets(record[i][j]+1,j,record);
        }
    }
}
