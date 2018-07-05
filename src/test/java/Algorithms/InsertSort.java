package Algorithms;

/**
 * 插入算法
 * Creator : LaiHaoDa
 * Date    : 2018-07-05 10:51
 */
public class InsertSort {

    public static void main(String[] args) {

        int[] arr = SortTools.getRandArr(1000,1,100);
        SortTools.printArr(arr);

        SortTools.consumeTime(arr, InsertSort.class,"sort");
        SortTools.consumeTime(arr, SelectionSort.class,"sort");

        sort(arr);
        SortTools.isSortRight(arr);

        SortTools.printArr(arr);

    }


    /**
     * 插入排序算法
     *    A B C D
     *    ---->
     *        第一种:正常插入算法
     *        1. A>B   B A
     *        2. A>C   B C A   B>C  C B A
     *        3  ...
     *    思路：从左往右轮询，坐标=1开始进行比较(第一次轮询取的k数组区间与下一个轮询(从大到小)内容第k+1进行比较内容)
     * @param arr
     */
    public static void sort(int[] arr){
        int size = arr.length;
        for(int k = 1;k < size;k++){
            for (int z=k;z>0;z--){
                if(arr[z] < arr[z-1])
                    SortTools.swapArr(arr,(z-1),z);
                else
                    break;
            }
        }
    }
}
