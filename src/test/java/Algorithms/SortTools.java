package Algorithms;

import java.util.Random;

/**
 * 排序的工具类
 * Creator : LaiHaoDa
 * Date    : 2018-07-05 10:07
 */
public class SortTools {

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
            arr[k]=random.nextInt(minute)+min+1;
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
