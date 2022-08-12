package com.fy.practice;

import org.junit.Test;

/**
 * @Classname CreateTree
 * @Description TODO
 * @Date 2021/4/16 20:45
 * @Created by fy
 */
public class CreateTree {


    @Test
    public void test(){
        char[] pre = {'C','E','F','D','B','H','G','A'};
        char[] in = {'C','B','E','D','F','A','H','G'};
        BTNode rst = inandpost(pre, in, 0, 7, 0, 7);
        pretraverse(rst);
    }

    //前序和中序确定一个二叉树
    public BTNode inandpre(char[] pre,char[] in,int L1,int R1,int L2,int R2){
        BTNode s = new BTNode();
        int i;
        if (L1 > R1){
            return null;
        }
        for(i = L2; i<= R2; ++i){
            if(pre[L1]==in[i]){
                break;
            }
        }
        s.setData(pre[L1]);
        s.setLchild(inandpre(pre,in, L1+1, L1+i-L2, L2,i-1));
        s.setRchild(inandpre(pre, in, L1+i-L2+1, R1-1,i+1, R2));
        return s;
    }
    //后序和中序确定一个二叉树
    public BTNode inandpost(char[] post,char[] in,int L1,int R1,int L2,int R2){
        BTNode s = new BTNode();
        if(L1 > R1){
            return null;
        }
        int i;
        for(i=L2;i<=R2;++i){
            if(post[R1] == in[i]){
                break;
            }
        }
        System.out.println(i);
        s.setData(post[R1]);
        s.setLchild(inandpost(post, in,L1, L1+i-L2-1,L2 , i-1));
        s.setRchild(inandpost(post, in, L1+i-L2,R1-1,i+1,R2));
        return s;
    }


    public void pretraverse(BTNode bt){
        if(bt != null){
            System.out.print(bt.getData()+"\t");
            pretraverse(bt.getLchild());
            pretraverse(bt.getRchild());
        }

    }

}



class BTNode{
    private char data;
    private BTNode lchild;
    private BTNode rchild;

    public char getData() {
        return data;
    }

    public void setData(char data) {
        this.data = data;
    }

    public BTNode getLchild() {
        return lchild;
    }

    public void setLchild(BTNode lchild) {
        this.lchild = lchild;
    }

    public BTNode getRchild() {
        return rchild;
    }

    public void setRchild(BTNode rchild) {
        this.rchild = rchild;
    }
}
