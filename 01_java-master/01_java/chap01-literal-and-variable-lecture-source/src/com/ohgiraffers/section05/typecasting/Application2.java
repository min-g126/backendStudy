package com.ohgiraffers.section05.typecasting;

public class Application2 {

    public static void main(String[] args) {

        /* 강제형변환 */
        /* 바꾸려는 자료형으로 캐스트 연산자를 이용하여 형변환한다.
        * 예) (바꿀자료형) 값;
        * */

        /* 자동형변환 규칙의 반대 상황에서 강제 형변환이 필요하다. */
        /* 1. 강제 형변환 규칙
        * 1-1. 큰 자료형에서 작은 자료형으로 변경 시 강제 형변환이 필요하다.
        * 1-2. 실수를 정수로 변경 시 강제 형변환이 필요하다.
        * 1-3. 문자형을 int미만 크기의 변수에 저장할 때 강제 형변환이 필요하다.
        * 1-4. 논리형은 강제 형변환 규칙에서도 제외된다.
        * */

        /* 1-1. 큰 자료형에서 작은 자료형으로 변경 시 강제 형변환이 필요하다. */
        /* 1-1-1. 정수 끼리의 강제 형변환 */
        long lnum = 8;
//        int inum = lnum;      //데이터 손실 가능성을 컴파일러가 알려준다.
        int inum = (int) lnum;  //변경하려는 자료형을 명시해서 강제 형변환을 해야 함.

        short snum = (short) inum;
        byte bnum = (byte) snum;

        /* 1-1-2. 실수 끼리의 강제 형변환 */
        double dnum = 8.0;
//        float fnum = dnum;
        float fnum = (float) dnum;
        System.out.println(fnum);


        /* 1-2. 실수를 정수로 변경 시 강제 형변환이 필요하다. */
        float fnum2 = 4.0f;
//        long lnum2 = fnum2;
        long lnum2 = (long) fnum2;


        /* 1-3. 문자형을 int미만 크기의 변수에 저장할 때 강제 형변환이 필요하다. */
        char ch = 'a';
        byte bnum2 = (byte) ch;
        short snum2 = (short) ch;

        /* 추가적으로 정수를 char 자료형에 강제 형변환해서 대입하기 테스트 */
        int num1 = 97;
        int num2 = -97;

        char ch2 = (char) num1;
        char ch3 = (char) num2;

        System.out.println("ch2 : " + ch2);
        System.out.println("ch3 = " + ch3);

        /* 1-4. 논리형은 강제 형변환 규칙에서도 제외된다. */
        /* 강제 형변환을 해도 전부 에러난다. */
        boolean isTrue = true;
//        byte b = (byte) isTrue;
//        short s = (short) isTrue;
//        int i = (int) isTrue;
//        float f = (float) isTrue;
//        double d = (double) isTrue;
//        char c = (char) isTrue;

    }
}
