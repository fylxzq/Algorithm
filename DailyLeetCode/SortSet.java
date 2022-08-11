package DailyLeetCode;

import org.junit.Test;

/**
 * @Classname SortSet
 * @Description TODO
 * @Date 2021/1/12 11:36
 * @Created by fy
 */
public class SortSet {

    @Test
    public void Test(){
        int[] arr1 = {8,2,1,1,0,6};
        insertSort(arr1);
        printArr(arr1);
        int[] arr2 = {20,13,7,2,12,11,9,1};
        mergeSort(arr2,0,7);
        printArr(arr2);
        int[] arr3 = {20,13,7,2,12,11,9,1};
        QuickSort(arr3,0,7);
        printArr(arr3);
        int[] arr4 = {2,3,1,4,5,6,2,1,4,8,7,9};
        CountSort(arr4);
    }

    //插入排序
    public void insertSort(int[] arr){
        int len = arr.length;
        for(int i=1;i<len;++i){//从第二个数开始
            int key = arr[i];
            int j = i - 1;
            while (j>=0){
                if(arr[j]>key){
                    arr[j+1] = arr[j];
                    --j;
                }
                else{
                    break;
                }
            }
            arr[j+1] = key;
        }
    }
    //归并排序
    public void mergeSort(int[] Arr,int left,int right){
        if(right==left){
            return;
        }
        else{
            int mid = (left + right) / 2;
            mergeSort(Arr,left,mid);
            mergeSort(Arr,mid+1,right);
            merge(Arr,left,mid,right);
        }
    }
    //快速排序
    public void QuickSort(int[] Arr,int p,int q){
        if(p<q){
            int mid = partition(Arr,p,q);
            QuickSort(Arr,p,mid-1);
            QuickSort(Arr,mid+1,q);
        }
    }

    private int  partition(int[] arr, int p, int q) {
        int x = arr[p];
        int i = p;//从p+1到i之间的数应该都是小于x的，从i+1到j的都是大于x的
        for(int j = p+1;j<=q;++j){
            if(arr[j]<=x){
                i = i + 1;
                int tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
            }
        }
        //把第一个数移动到中间，返回那个数的索引
        arr[p] = arr[i];
        arr[i] = x;
        return i;
    }
    public void CountSort(int[] arr){
        int len = arr.length;
        int[] copyarr = new int[len];
        int[] assistarr =  new int[10];
        for(int i=0;i<len;++i){
            assistarr[arr[i]] = assistarr[arr[i]] + 1;
        }
        for(int i=1;i<10;++i){
            if(arr[i]==0){
                assistarr[0] += 1;
            }
            else {
                assistarr[i] = assistarr[i] + assistarr[i-1];
            }
        }

        for(int i=len-1;i>=0;--i){//从后往前保证是稳定排序
            copyarr[assistarr[arr[i]]-1] = arr[i];
            //这里注意有12个数大于等于，应该是在索引11的位置，所以要减一
            assistarr[arr[i]] = assistarr[arr[i]]-1;
        }
    }
    //将分成两半的有序数组合并起来
    private void merge(int[] arr, int left, int mid, int right) {
        int totallen = right - left + 1;
        int[] tmparr = new int[totallen];
        //创建一个暂时的数组，存放合并后的数组，然后在从此数组放到原数组
        int i = left;
        int j = mid + 1;
        int k = 0;
        //三个while循环是为了合并两个有序数组到一个，很像两个链表的合并
        while (i<=mid && j<= right){
            if(arr[i]<arr[j]){
                tmparr[k] = arr[i];
                ++i;
                ++k;
            }
            else{
                tmparr[k] = arr[j];
                ++j;
                ++k;
            }
        }
        while (i<=mid){
            tmparr[k] = arr[i];
            ++i;
            ++k;
        }

        while (j<=right){
            tmparr[k] = arr[i];
            ++i;
            ++k;
        }
        //复制到原数组
        j = left;
        for(i = 0;i<totallen;++i){
            arr[j] = tmparr[i];
            j++;
        }
    }

    public void printArr(int[] arr){
        int len = arr.length;
        for(int i=0;i<len;++i){
            System.out.print(arr[i]+"\t");
        }
        System.out.println();
    }

}
