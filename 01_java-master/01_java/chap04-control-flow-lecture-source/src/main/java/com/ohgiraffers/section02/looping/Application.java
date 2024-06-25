package com.ohgiraffers.section02.looping;

public class Application {

    public static void main(String[] args) {

        A_for a = new A_for();
        /* 단독 for문 흐름 확인용 메소드 호출 */
//        a.testSimpleForStatement();

        /* 반복문을 사용하는 예제 */
//        a.testForExample1();
//        a.testForExample2();
//        a.testForExample3();
//        a.testForExample4();

        /* 반복문을 일상 생활에서 사용하는 예제 (규칙찾기)*/
//        a.printSimpleGugudan();

        A_nestedFor a2 = new A_nestedFor();
        /* 중첩 반복문을 사용하는 예제 */
//        a2.printTriangleStars();
//        a2.printGugudanFromTwoToNine();
//        a2.printUpgradeGugudanFromTwoToNine();
//        a2.printStarInputRowTimes();

        B_while b = new B_while();
        /* 단독 while문 흐름 확인용 메소드 호출 */
//        b.testSimpleWhileStatement();

        /* 반복문을 사용하는 예제(for문과 비교) */
//        b.testWhileExample1();
//        b.testWhileExample2();
//        b.testWhileExample3();

        C_doWhile c = new C_doWhile();
//        c.testSimpleDoWhileStatement();

        /* do-while 반복문을 사용하는 예제 */
//        c.testDoWhileExample1();




    }
}
