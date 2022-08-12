package com.fy.practice;

/**
 * @Classname LeVelTraverse
 * @Description TODO
 * @Date 2021/5/16 11:01
 * @Created by fy
 */
public class LeVelTraverse {

}
  /*  static int pos =0;
    public static void main(String[] args) {
        String str = "ABD__E__CFH__I__G__";
        BTNode bt= createTree(str);
        level(bt);
        //pretraverse(bt);
    }


    public static void level(BTNode bt){
        //定义一个队列，数组的长度不能小于树的最大宽度
        BTNode[] queue = new BTNode[10];
        //局部变量p用来接收从队列中出队的元素
        BTNode p = null;
        int maxsize = queue.length;
        //front和rear代表队头和队尾指针
        int front=0,rear=0;
        //函数主要部分
        if(bt != null){
            rear = (rear+1) % maxsize;
            //根节点入队
            queue[rear] = bt;
            while (front != rear){//队列不为空则继续取出队列元素
                //取出队列元素并访问
                front = (front+1)%maxsize;
                p = queue[front];
                System.out.println(p.value+"");
                //取出的元素左子树不为空，入队
                if(p.lchild!=null){
                    rear = (rear+1) % maxsize;
                    queue[rear] = p.lchild;
                }
                //取出的元素右子树不为空，入队
                if(p.rchild != null){
                    rear = (rear+1) % maxsize;
                    queue[rear] = p.rchild;
                }
            }

        }
    }









    public static BTNode createTree(String str){
        if(pos > str.length() || str.charAt(pos)=='_'){
            return null;
        }
        else{
            BTNode bt = new BTNode();
            bt.value = str.charAt(pos);
            pos++;
            bt.lchild = createTree(str);
            pos++;
            bt.rchild = createTree(str);
            return bt;
        }

    }

    public static void pretraverse(BTNode bt){
        if(bt!=null){
            System.out.println(bt.value+"");
            pretraverse(bt.lchild);
            pretraverse(bt.rchild);
        }
    }

}

class BTNode{
    BTNode lchild =null;
    BTNode rchild = null;
    char value;
}
*/