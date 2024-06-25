package com.ohgiraffers.section02.variable;

public class Application2 {

    public static void main(String[] args) {

        /* 변수를 사용하기 위한 방법 */
        /* 1. 변수를 준비한다. (선언)
        * 2. 변수에 값을 대입한다. (값 대입 및 초기화)
        * 3. 변수를 사용한다. (호출)
        * */

        /* 1. 변수를 준비한다. (선언) */
        /* 1-1. 변수를 선언하는 방법 */
        /* 자료형 변수명; */

        /* 자료형이란?
        * 다양한 값의 형태별로 어느 정도의 크기를 하나의 값으로 취급할 것인지 미리 Compiler와 약속한 키워드이다.
        * 예) 앞에서 사용한 int 자료형은 정수를 4byte만큼을 읽어서 하나의 값으로 취급하겠다는 약속이다.
        * 이러한 자료형은 기본자료형(Primitive type)과 참조자료형(Reference type)으로 나누어진다.
        * 그 중 기본자료형 8가지 부터 살펴보기로 한다.
        */

        /* byte에 대한 설명은 변수를 전부 선언해본 뒤에 이론 설명을 참고한다. */

        /* 1-1-1. 숫자를 취급하는 자료형 */
        /* 정수를 취급하는 자료형은 4가지가 있다. */
        byte bnum;      //1byte
        short snum;     //2byte
        int inum;       //4byte
        long lnum;      //8byte

        /* 실수를 취급하는 자료형은 2가지가 있다. */
        float fnum;     //4byte
        double dnum;    //8byte

        /* 1-1-2. 문자를 취급하는 자료형 */
        /* 문자를 취급하는 자료형은 한 가지가 있다. */
        char ch;        //2byte
        char ch2;

        /* 1-1-3. 논리값을 취급하는 자료형 */
        boolean isTrue;  //1byte

        /* 이상 8가지를 기본자료형(Primitive type)이라고 한다. */

        /* 1-1-4. 문자열을 취급하는 자료형 */
        String str;     //4byte (엄밀히 이야기하면 주소값은 4byte의 정수형이다.)

        /* 2. 변수에 값을 대입한다. (값 대입 및 초기화) */
        /* 위에서 한 변수 선언은 메모리에 값을 저장하기 위해 공간만 생성해 둔 상태이다.
        * 그 공간에 대입연산자를 이용하여 자료형에 저장하기로 한 형태의 값을 저장할 수 있다.
        * 만약, 약속 내용과 다른 형태의 값을 대입하려고 하면 Compiler는 에러를 발생시킨다.
        *
        * 대입 연산자의 실행 방향은 오른쪽에서 왼쪽이다.
        * 즉, 오른쪽에 있는 값을 왼쪽의 공간에 대입한다는 의미이며, 왼쪽에는 항상 공간, 오른쪽에는 항상 값이 온다.
        * 변수를 대입연산자 왼쪽에 사용하면 공간의 의미이고, 대입연산자 오른쪽에 사용하면 변수가 가진 값을 의미한다. */
        /* 2-1. 정수를 취급하는 자료형에 값 대입 */
        bnum = 1;
        snum = 2;
        inum = 4;
        lnum = 8L;

        /* 2-2. 실수를 취급하는 자료형에 값 대입 */
//        fnum = 4.0;
        fnum = 4.0f;    //실수 뒤에 'f'를 붙여야 한다. 대문자 'F'도 가능하지만 소문자를 사용하는 것이 일반적이다.
        dnum = 8.0;

        /* 2-3. 문자를 취급하는 자료형에 값 대입 */
        ch= 'a';
        ch2 = 97;

        /* 2-4. 논리를 취급하는 자료형에 값 대입 */
        isTrue = true;
        isTrue = false;

        /* 2-5. 문자열을 취급하는 자료형에 값 대입 */
        str = "안녕하세요";

        /* 숫자로 된 형태의 값을 그대로 사용하는 자료형은 byte, short, int, double이다. */
        /* 일반적으로 사용하는 값을 독특한 형태가 아닌 일반적인 형태로 사용할 수 있는 자료형을 대표자료형이라고 하며
        * 정수형은 int, 실수형은 double이 대표 자료형이다.
        *
        * 정수의 경우는 일상 생활에서 많이 사용되는 숫자의 범위는 byte와 short으로 표현이 불가능한 경우가 많다.
        * 따라서 int를 대표자료형으로 여기며, 특수한 경우가 아닌 이상 byte와 short은 잘 사용하지 않는다.
        * 실수의 경우는 정확도를 기준으로 4byte 자료형보다 8byte 자료형이 더 정확한 실수를 표현할 수 있기 때문에 double을 대표자료형으로 사용하고
        * float는 특수한 목적이 있는 경우에만 사용하게 된다. */

        /* 위처럼 변수를 선언하고 난 뒤 최초로 값이 대입되는 것을 초기화 라고 한다. */
        /* 위에서는 변수 선언과 값 대입을 따로 했지만 동시에 수행할 수도 있다.
        * 명칭이 중요하지는 않지만 이 것을 '선언과 동시에 초기화' 라고 한다.
        * */
        int point = 100;
        int bonus = 10;

        /* 3. 변수를 사용한다. */
        /* 3-1. 변수에 저장한 값 출력하기 */
        /* 위에서 선언 후 초기화 한 변수들을 출력해보자 */
        System.out.println("========== 변수에 저장된 값 출력 ===========");
        System.out.println("bnum의 값 : " + bnum);
        System.out.println("snum의 값 : " + snum);
        System.out.println("inum의 값 : " + inum);
        System.out.println("lnum의 값 : " + lnum);

        System.out.println("fnum의 값 : " + fnum);
        System.out.println("dnum의 값 : " + dnum);

        System.out.println("ch의 값 : " + ch);
        System.out.println("ch2의 값 : " + ch2);

        System.out.println("isTrue의 값 : " + isTrue);

        System.out.println("str의 값 : " + str);


        /* 3-2. 변수를 이용해서 연산하기 */
        /* 변수에 저장된 값을 이용해서 연산을 할 수도 있다. */
        System.out.println("포인트와 보너스의 합은? : " + (point + bonus));

        /* 3-3. 대입연산자의 왼쪽과 오른쪽 편에 사용하기 */
        /* 대입연산자의 왼편에는 공간이라는 의미, 오른 편에는 값이라는 의미이다.
         * 따라서 point라는 공간에 point가 가지고 있는 값에 + 100한 값을 대입하라는 의미이다.
         * */
        point = point + 100;

        System.out.println("point = point + 100 ? " + point);

//        System.out.println("실행");
    }
}
