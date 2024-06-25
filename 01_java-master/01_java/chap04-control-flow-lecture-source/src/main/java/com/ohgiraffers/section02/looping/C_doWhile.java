package com.ohgiraffers.section02.looping;

import java.util.Scanner;

public class C_doWhile {

    public void testSimpleDoWhileStatement() {

        /* do-while문 단독 사용에 대한 흐름을 이해하고 적용할 수 있다. */
        /*[do-while문 표현식]
        * 초기식;
        * do {
        *       1회차에는 무조건 실행하고, 이후에는 조건식을 확인하여 조건을 만족하는 경우 수행할 구문(반복할 구문);
        *       증감식;
        * } while(조건식)
        * */

        /* 조건을 false로 두고 실행 되는지 테스트 */
        do {

            /* 조건식의 결과와 상관 없이 최초 1번은 무조건 동작함 */
            System.out.println("최초 한 번 동작함...");
        } while (false);

        System.out.println("반복문 종료 확인...");

    }

    public void testDoWhileExample1() {

        /* do-while문의 흐름을 이해하고 적용할 수 있다. (1) */
        /* 키보드로 문자열 입력받아 반복적으로 출력
        * 단, exit가 입력되면 반복문을 종료한다.
        * */
        Scanner sc = new Scanner(System.in);
        String str = "";
        do {


            System.out.println("문자열을 입력하세요 : ");
            str = sc.nextLine();
            System.out.println(str);


            /*equals() : 문자열은 == 비교가 불가능하다. 문자열이 같은지를 비교하는 기능을 제공한다.*/
        } while (!str.equals("exit"));

        System.out.println("프로그램을 종료합니다.");

    }
}
