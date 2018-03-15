package com.myboot.demo.simple;

import org.junit.Test;

public class TwoSimple {

    static String kangaroo(int x1, int v1, int x2, int v2) {
        // Complete this function
        boolean isOneFirst=(x1>x2),
                isOneFast=(v1>v2);
        if((isOneFast && isOneFirst) || (!isOneFast && !isOneFirst))
            return "NO";

        int perSize=0;
        while (perSize<=10000){
            boolean t=((x1+v1*perSize)==(x2+v2*perSize));
            if(t)
                break;
            perSize++;
        }

        return (perSize<=10000)?"YES":"NO";
    }



    @Test
    public void  test3(){
        System.out.println(kangaroo(0,2,5,3));
        System.out.println(kangaroo(0,3,4,2));
        System.out.println(kangaroo(63,8,94,3));
    }


}
