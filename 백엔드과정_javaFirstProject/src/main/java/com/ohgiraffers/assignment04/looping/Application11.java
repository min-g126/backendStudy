package com.ohgiraffers.assignment04.looping;

import java.util.Scanner;

public class Application11 {

    public static void main(String[] args) {

        /* 받은 금액을 입력 받고, 상품 가격을 입력 받아 거스름돈을 계산하는 프로그램을 작성하세요
         *
         * 단, 거스름돈은 대한민국 화폐 단위 별 필요 수량이 출력되도록 작성하고,
         * 지폐외 동전을 구분하여 단위를 표기하세요.
         *
         * -- 입력 예시 --
         * 받으신 금액을 입력하세요 : 100000
         * 상품 가격을 입력하세요 : 22340
         *
         * -- 출력 예시 --
         * ============================
         * 50000원권 지폐 1장
         * 10000원권 지폐 2장
         * 5000원권 지폐 1장
         * 1000원권 지폐 2장
         * 500원권 동전 1개
         * 100원권 동전 1개
         * 50원권 동전 1개
         * 10원권 동전 1개
         * ============================
         * 거스름돈 : 77660원
         * */


        Scanner sc = new Scanner(System.in);
        System.out.print("받으신 금액을 입력하세요: ");
        int money = sc.nextInt();

        System.out.print("상품 가격을 입력하세요: ");
        int price = sc.nextInt();

        int change = money - price;

        // 화폐 단위 배열
        int[] unit = {50000, 10000, 5000, 1000, 500, 100, 50, 10};
        // 화폐 개수 배열
        int[] count = new int[unit.length];

        //화폐단위 배열 반복
        for (int i = 0; i < unit.length; i++) {
            //거스름돈을 나눈 몫을 count 배열에 넣기
            count[i] = change / unit[i];
            //나머지를 chage 변수에 저장
            change %= unit[i];
        }

        // 출력
        System.out.println("============================");
        for (int i = 0; i < unit.length; i++) {
            if (count[i] > 0) {
                //지폐일때
                if (unit[i] >= 1000) {
                    System.out.println(unit[i] + "원권 지폐 " + count[i] + "장");
                }
                //동전일때
                else {
                    System.out.println(unit[i] + "원권 동전 " + count[i] + "개");
                }
            }
        }
        System.out.println("============================");
        System.out.println("거스름돈: " + (money - price) + "원");
    }


}
