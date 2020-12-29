package DailyLeetCode;

import org.junit.Test;

/**
 * @Classname Fasest_way
 * @Description 动态规划解决装配线调度问题
 * @Date 2020/12/29 15:11
 * @Created by fy
 */
public class Fasest_way {

    @Test//测试案例
    public void Test(){
        int[][] a = {{7,9,3,4,8,4},{8,5,6,4,5,7}};
        int[][] t = {{2,3,1,3,4},{2,1,2,2,1}};
        int e1 = 2;
        int e2 = 4;
        int x1 = 3;
        int x2 = 2;
        int[] rst = getFastTime(a,t,e1,e2,x1,x2,6);
        System.out.println(rst[1]);
        System.out.println(rst[0]);
    }

    public int[] getFastTime(int[][] a,int[][] t,int e1,int e2,int x1,int x2,int n){
        int len = n;
        int[][] f = new int[2][len];
        int[][] l = new int[2][len];//l[i][j]为以最快路线通过 Si,j时第 j-1个站点线号

        f[0][0] = e1+a[0][0];
        f[1][0] = e2+a[1][0];
        l[0][0] = 0;
        l[1][0] = 1;
        for(int i=1;i<len;++i){
            f[0][i] = Math.min(f[0][i-1]+a[0][i],f[1][i-1]+t[1][i-1]+a[0][i]);
            l[0][i] = ((f[0][i-1]+a[0][i])>(f[1][i-1]+t[1][i-1]+a[0][i])) ? 1:0;//三目运算符
            f[1][i] = Math.min(f[1][i-1]+a[1][i],f[0][i-1]+t[0][i-1]+a[1][i]);
            l[1][i] = ((f[1][i-1]+a[1][i])>(f[0][i-1]+t[0][i-1]+a[1][i])) ? 0:1;
        }
        int llast = (f[0][n-1]+x1)>(f[1][n-1]+x2) ? 1:0;
        return new int[]{Math.min(f[0][n-1]+x1,f[1][n-1]+x2),llast};//返回最小值和最后是从哪个生产线出去的
    }
}
