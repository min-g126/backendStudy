package com.ohgiraffers.section02.looping;

import java.util.Scanner;

public class A_nestedFor {

    public void printGugudanFromTwoToNine() {

        /* 중첩된 for문의 흐름을 이해하고 적용할 수 있다. (1)*/
        /* for문 안에서 for문을 이용할 수 있다. */
        /* 2단부터 단을 1씩 증가시키는 반복문 */
        for (int dan = 2; dan < 10; dan++) {

            /* 단이 1개씩 증가하는 동안 수행할 내용은 해당 단의 구구단을 출력하는 것이다. */
            for (int su = 1; su < 10; su++) {

                System.out.println(dan + " * " + su + " = " + (dan * su));
            }

            /* 한 단이 출력되고 나면 한 줄을 띄운다 */
            System.out.println();
        }
    }

    public void printUpgradeGugudanFromTwoToNine() {

        /* 중첩된 for문의 흐름을 이해하고 적용할 수 있다. (2) */
        /* 단을 2단부터 9단까지 하나씩 증가시킨다. */
        for (int dan = 2; dan < 10; dan++) {

            /* 한 단씩 구구단을 출력하는 메소드를 호출하며 인자로 단을 전달한다. */
            printGugudanOf(dan);
            /* 한 단을 출력하고 한 줄을 띄운다. */
            System.out.println();
        }
    }

    public void printGugudanOf(int dan) {

        /* 매개변수로 전달받은 단을 1~10까지 곱한 내용을 출력해준다. */
        for (int su = 1; su < 10; su++) {
            System.out.println(dan + " * " + su + " = " + (dan * su));
        }
    }

    public void printStarInputRowTimes() {

        /* 중첩된 for문의 흐름을 이해하고 적용할 수 있다. (3) */
        /* 키보드로 정수를 하나 입력 받아 해당 정수 만큼 한 행에 "*"을 5개씩 출력하세요
        * */

        Scanner sc = new Scanner(System.in);
        System.out.println("출력할 행 수를 입력하세요 : ");
        int row = sc.nextInt();

        /* 입력한 행 만큼 반복 */
        for (int i = 1; i < row; i++) {

            /* 별을 5개 출력하는 것을 반복 */
//            for (int j = 1; j < 6; j++) {
//                System.out.println("*");
//            }

            /* 위 기능을 수행하는 메소드 추가해서 호출로 변경 */
            printStar(3);

            /* 별을 출력하고 난 뒤 줄 바꿈 */
            System.out.println();
        }
    }

    public void printStar(int times) {

        for (int i = 1; i <= times; i++) {
            System.out.println("*****");
        }
    }

    public void printTriangleStars() {

        /* 중첩된 for문의 흐름을 이해하고 적용할 수 있다. (4)*/

        /* 키보드로 정수를 하나 입력 받아 해당 정수 만큼 한 행에 "*" 을 행의 번호 개씩 출력하세요
        * 예시) 정수를 입력하세요 : 5
        *   *
        *   **
        *   ***
        *   ***
        *   *****
        * */

        /* 출력할 줄 수 입력 */
        System.out.println("출력할 줄 수를 입력하세요 : ");
        Scanner sc = new Scanner(System.in);
        int row = sc.nextInt();

        for (int i = 1; i <= row; i++) {

//            /* 행 수만큼만 별을 출력하는 반복문 */
//            for (int j = 1; j <= 1; j++) {
//                System.out.println("*");

                /* 위에 만들어 놓은 메소드 재사용하자 */
                printStar(i);
                System.out.println();

            }
        }
    }


