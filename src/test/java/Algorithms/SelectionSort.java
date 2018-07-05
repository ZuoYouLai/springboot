package Algorithms;

/**
 * 选择排序函数  n(o^2)  【基础】
 */
public class SelectionSort {


    public static void main(String[] args) {

        int[] arr = SortTools.getRandArr(1000,1,100);
        SortTools.printArr(arr);

        SortTools.consumeTime(arr, SelectionSort.class,"sort");

        sort(arr);
        SortTools.isSortRight(arr);

        SortTools.printArr(arr);


    }


    /**
     * 选择排序算法
     *    思路：从左往右轮询，在第二级轮询与第一级坐标值相比较（直达第二级轮询完则拿到最终的最小坐标值）
     *          发生与当前坐标与最小坐标值的互换
     * @param arr
     */
    public static void sort(int[] arr){
        for(int j = 0,size = arr.length;j<size;j++){
            int temp=j;
            for(int k=j+1;k<size;k++){
                //寻找最小的坐标 往后推
                if(arr[temp]>arr[k]){
                    temp=k;
                }
            }
            //一次轮循环拿到最小值的坐标值
            SortTools.swapArr(arr,j,temp);
        }
    }




}
