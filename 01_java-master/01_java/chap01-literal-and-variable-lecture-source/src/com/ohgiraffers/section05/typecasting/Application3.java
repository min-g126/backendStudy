package com.ohgiraffers.section05.typecasting;

public class Application3 {
    public static void main(String[] args) {

        /* 자동 형변환과 강제 형변환을 이용한 다른 자료형끼리의 연산 */
        /* 다른 자료형 끼리 연산은 큰 자료형으로 자동 형변환 후 연산 처리 된다. */
        int inum = 10;
        long lnum = 100;

        /* 자바에서는 같은 자료형끼리만 연산이 가능하다.
        * 따라서 서로 자료형이 다른 두 자료를 연산할 때 자료형이 같아지도록 형변환을 해 주어야 한다. */

        /* 방법1. 두 수의 연산 결과를 int 형으로 변환 후 int 자료형 변수에 리턴받는다. */
//        int isum = inum + lnum;
        int isum = (int) (inum + lnum);

        System.out.println("isum : " + isum);

        /* 방법2. long형 같은 값을 int로 강제 형변환 한다. */
        int isum2 = inum + (int) lnum ;

        System.out.println("isum2 = " + isum2);

        /* 방법3. 결과 값을 long형 자료형으로 받는다(자동 형변환 이용) */
        long lsum = inum + lnum;

        System.out.println("lsum = " + lsum);

        /* 주의! int 미만의 연산의 처리 결과는 int형 이다. */
        byte byteNum1 = 1;
        byte byteNum2 = 2;
        short shortNum1 = 3;
        short shortNum2 = 4;

        int result1 = byteNum1 + byteNum2;
        int result2 = byteNum1 + shortNum1;
        int result3 = shortNum1 + byteNum1;
        int result4 = shortNum1 + shortNum2;

        System.out.println("result1 = " + result1);
        System.out.println("result2 = " + result2);
        System.out.println("result3 = " + result3);
        System.out.println("result4 = " + result4);


    }
}
