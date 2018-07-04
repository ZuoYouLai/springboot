package Algorithms;


import java.util.Random;

/**
 * Samlai
 * 选择排序函数  n(o^2)  【基础】
 */
public class SelectionSort {


    public static void main(String[] args) {

        int[] arr = getRandArr(10,20,100);
        printArr(arr);


        sort(arr);
        printArr(arr);
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
            swapArr(arr,j,temp);
        }
    }


    /**
     * 数组坐标间的交换
     * @param arr
     * @param last
     * @param next
     */
    public static void swapArr(int[] arr,int last,int next){
       //当前坐标 与 最小坐标的比较  相等则不互换
       if(last == next) return;
       int z = arr[last];
       arr[last] = arr[next];
       arr[next] = z;
    }



    /**
     * 生成一个随机数组（整型）
     * @param size
     * @param min
     * @param max
     * @return
     */
    public static int[] getRandArr(int size,int min,int max){
        int[] arr=new int[size];
        int minute=max-min;
        Random random =new Random();
        for(int k=0;k<size;k++){
            //产生一个[min,max]之间的随机数
            arr[k]=random.nextInt(minute)+min;
        }
        return arr;
    }


    /**
     * 打印数组的内容
     * @param arr
     */
    public static void printArr(int[] arr){
        StringBuilder builder = new StringBuilder();
        for(int i:arr){
            builder.append("  "+i);
        }
        System.err.println(builder.toString());
    }

}
