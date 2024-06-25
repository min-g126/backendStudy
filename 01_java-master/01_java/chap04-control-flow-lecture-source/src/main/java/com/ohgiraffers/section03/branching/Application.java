package com.ohgiraffers.section03.branching;

public class Application {

    public static void main(String[] args) {

        A_break a = new A_break();
        /* break문 흐름 확인용 메소드 호출 */
//        a.testSimpleBreakStatement();
//        a.testSimpleBreakStatement2();
//        a.testJumpBreak();

        B_continue b = new B_continue();
//        b.testSimpleContinueStatement();
//        b.testSimpleContinueStatement2();
        b.testJumpContinue();
    }

}
