package com.myboot.demo.simple;

import com.sun.jmx.remote.internal.ArrayQueue;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Administrator on 2018/3/9.
 */
public class OneSimple {


    static String timeConversion(String s) {
        // Complete this function
        boolean isPm=(s.indexOf("PM")>-1);
        if(isPm){
            s=s.replace("PM","");
            String[] arr=s.split(":");
            String one=arr[0];
            int oneNum=Integer.parseInt(one);
            if(oneNum == 12){
                return "00:00:00";
            }
            oneNum+=12;
            return oneNum+":"+arr[1]+":"+arr[2];
        }else{
            return s.replace("AM","");
        }
    }



    static int[] solve(int[] grades){
        // Complete this function
        int [] kArr=new int[grades.length];
        for(int k=0;k<grades.length;k++){
            int target=grades[k];
            if(target>=38){
                int msize=(target % 5);
                if(msize>2){
                    target=target+(5-msize);
                }
            }
            kArr[k]=target;
            System.out.println(target);
        }
        return kArr;
    }

    @Test
    public void  test1(){

//    System.out.println(timeConversion("12:34:56AM"));

//        ArrayQueue

//    System.out.println(78%5);
    int[] arr=new int[]{30,78,11,38};
          arr=solve(arr);




    }






    static int[] circularArrayRotation(int[] a, int[] m) {
        // Complete this function
        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(m));
        int size=a[0];
        int[] newArr=new int[size];
        for(int k=0;k<size;k++){
            newArr[(a[1]+k)%size]=m[k];
            System.out.println((a[1]+k)%size+" --> "+m[k]);
        }
        for(int z=0;z<a[2];z++){
            System.out.println(newArr[z]);
        }
        return newArr;
    }

    @Test
    public void  test2(){

//        3 2 3
//        1 2 3
          int[] arr1=new int[]{3,2,3},
                arr2=new int[]{1,2,3};

        circularArrayRotation(arr1,arr2);


        ArrayList list=new ArrayList();

    }




    static void countApplesAndOranges(int s, int t, int a, int b, int[] apples, int[] oranges) {
        int aSize=0,bSize=0;
        for(int k:apples){
            int target=k;
            target+=a;
            if(s<=target && target<=t){
                aSize++;
            }
        }

        for(int k:oranges){
            int target=k;
            target+=b;
            if(s<=target && target<=t){
                bSize++;
            }
        }
        System.out.println(bSize);
        System.out.println(aSize);
    }



    @Test
    public void  test3(){
        System.out.println(16 >> 1);
        System.out.println(16 >> 2);
        System.out.println(16 << 1);
        System.out.println(16 << 2);


//        ArrayDeque
    }


    static int[] breakingRecords(int[] score) {
        int minSize=0, maxSize=0,min=score[0],max=score[0];
        for(int k=1;k<score.length;k++){
            if(min<score[k]){
                min=score[k];
                minSize++;
            }else if(max>score[k]){
                max=score[k];
                maxSize++;
            }
        }
        score=new int[2];
        score[0]=maxSize;
        score[1]=minSize;
        return score;
    }




}
