package Algorithms;

import java.lang.reflect.Method;
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


    /**
     * 打印树的内容字符值
     * @param arr
     */
    public static void printTreeStr(int[] arr,int count){
        //行数: 1 2 4 8 16 32 ...
        /**
         *   1  1
         *   3  2
         *   7  3
         *   15 4
         *   31 5
         *   规律为：2的n次方减1
         */

        /***
         * 列数为:
         *    2的n+1次方+
         *    3
         *    5
         *    9
         *    14
         */
        //先求出满树的行数
        double pfg = Math.sqrt((count+1)*1.0);
        int lineNum = (int)(Math.ceil(pfg));
        for(int z = 1 ; z <= lineNum ; z++){
            if(z != lineNum){
                //不是最后一行操作
                int temp = (int) Math.pow(z,2);
                for(int m = 0 ; m < (2*temp+1)  ;m++){
                    if(m%2==0){
                        System.out.print(" ");
                    }else{
                        int point=(z==1)?1:(2*(z-1)+(m/2));
                        System.out.print(arr[point]);
                    }
                }
            }else{
                int totalSum = 0;
                for(int p = 1;p<=(lineNum-1);p++){
                    totalSum += (int) Math.pow((p-1)*1.0,2.0);
                }
                for(int n = 0 ; n < count-totalSum  ;n++){
                    if(n%2==0){
                        System.out.print(" ");
                    }else{
                        int point=(z==1)?1:(2*(z-1)+(n/2));
                        System.out.print(arr[point]);
                    }
                }
            }
            System.out.println();

        }


    }




    /**
     * 进行获取排序算法的消耗时间，以比较性能
     * @param arr
     * @param cls
     * @param methodName
     */
    public static void consumeTime(int[] arr,Class cls,String methodName){
        //通过反射机制 运行函数
        try {
            //通过排序函数class对象获取排序的方法
            Method sortMethod = cls .getMethod(methodName,new Class[]{int[].class});
            //排序参数只有一个，是可毕竟数组arr
            long start = System.currentTimeMillis();
            sortMethod.invoke(null,arr);
            long end = System.currentTimeMillis();
            System.err.println(String.format("%s , consume time  : %d ms",cls.getSimpleName(),(end-start) ));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * 校验排序结果是否正确
     * @param arr
     * @return
     */
    public static boolean isSortRight(int arr[]){
        boolean flag= true;
        for(int k=0,total=arr.length ; k<(total-1) ; k++){
            if(arr[k]>arr[k+1]){
                flag = false;
                break;
            }
        }
        System.err.println("排序的结果  :  "+flag);
        return flag;
    }



}
