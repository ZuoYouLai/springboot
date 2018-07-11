package Algorithms;


import java.util.Random;

/**
 * 堆排序:
 *
 * 思路内容：堆排序  ----> 最大二叉树的排序（父节点是大于等于子节点的完全二叉树内容）
 * 公式：
 *      parentId = x/2 (向下取整)
 *      子节点 : 左节点 (2*parentId)
 *               右节点 (2*parentId+1)
 * 特点：
 *      从第一个元素进行开始构建（故第0是没有值）
 *      最大的max在第一个节点
 *
 * 时间复杂度：
 *      nlogM
 *
 * shiftUp的操作：
 *      向上比较
 *
 * shiftDown的操作
 *      向下比较操作
 *
 */
public class MaxHeap {
    private int[] arr;
    private int count;
    public MaxHeap(int capacity){
        arr = new int[capacity];
        count++;
    }
    /**
     * 获取堆长度
     * @return
     */
    public int getCount(){
        return count;
    }

    /**
     * 添加一个元素
     * @param oneElement
     */
    public void insertElement(int oneElement){
        arr[count] = oneElement;
        shiftUp(count);
        count++;
    }

    /**
     * 去掉最顶端值进行出堆操作，最终会出现意想不到的结果 ：从大到小排序
     */
    public int removeMax (){
         if(count == 1)
             return arr[1];
         arr[1] = arr[count];
         count --;
         return shiftDown(count);
    }

    /**
     * 去掉顶端值，将最后一个进行将第一个元素进行补上
     * @param k
     */
    private int shiftDown(int k) {
        while ((k*2)<=count){
            int temp = (k * 2);
            if((temp+1) <= count && arr[temp] < arr[temp+1])
                temp =temp+1;
            if(arr[k] > arr[temp])
                break;
            SortTools.swapArr(arr,temp,k);
            k = temp;
//            int leftChild = arr [k*2];
//            if((k*2+1)<=count){
//                if(leftChild > arr[k]){
//                    SortTools.swapArr(arr,k*2,k);
//                }
//                int righetChild = arr[k*2+1];
//                int temp = (righetChild>=leftChild)?(k*2+1):(k*2);
//            }else {
//                //只有一个左子节点 大于 当前元素内容
//                if(leftChild > arr[k]){
//                    SortTools.swapArr(arr,k*2,k);
//                }else{
//                    // 左子节点 小于 当前元素 则不再往下执行
//                    break;
//                }
//            }
        }
        return arr[k];
    }

    /**
     * 与父元素进行是否交换的操作内容
     * @param k
     */
    private void shiftUp(int k) {
        while (k>1 && arr[k/2]<arr[k]){
            SortTools.swapArr(arr,(k/2),k);
            k = k/2;
        }
    }


    public static void main(String[] args) {
        int z = 10;
        MaxHeap heap = new MaxHeap((z*2));
        for(int k=0;k<z;k++){
            heap.insertElement(new Random().nextInt(101));
        }
        //100  50  34  5  48
        /**
         *        100           1  + 2  = 1+1+1
         *     50    34         2  + 3  = 2+2+1
         *    5  48             4  + 5
         *                      8  + 6
         *    99  92  73  85  50  8  7  38  16  41
         */
        SortTools.printArr(heap.arr);

        SortTools.printTreeStr(heap.arr,heap.count);

//        int[] arr = new int[z];
//        for(int k =0 ;k < z ;k++){
//            arr[k] = heap.removeMax();
////            System.err.println(heap.removeMax());
//        }
//        SortTools.printArr(arr);
//        SortTools.isSortRight(arr);
    }
}
