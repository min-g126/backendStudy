package com.ohgiraffers.assignment04.conditional;

import java.util.Scanner;

public class Application6 {

    public static void main(String[] args) {

        /* 토끼는 축제 간식 부스에서 일하게 됐어요.
         *
         * 간식 이름("캬라멜팝콘", "츄로스", "통감자", "도토리탕후루") 중 한 가지를 문자열로 입려하면
         * 해당하는 가격에 맞게 상품명과 가격이 출력되게 하세요.
         *
         * 단, 목록에 없는 과일을 입력 시 "해당 상품이 판매하지 않습니다." 출력 후 프로그램을 종료합니다.
         *
         * -- 상품 가격 --
         * 캬라멜팝콘 : 15500원
         * 츄로스 : 3000원
         * 통감자 : 2000원
         * 도토리탕후루 : 5000원
         *
         * -- 입력 예시 --
         * 어떤 간식을 주문하시겠어요? 도토리탕후루
         *
         * -- 출력 예시 --
         * 도토리탕후루의 가격은 5000원 입니다.
         * */


        Scanner sc = new Scanner(System.in);
        System.out.println("어떤 간식을 주문하시겠어요? (캬라멜팝콘, 츄로스, 통감자, 도토리탕후루)");
        String food = sc.nextLine();

        if(food.equals("캬라멜팝콘")){
            System.out.println("캬라멜팝콘의 가격은 15500원 입니다.");
        } else if (food.equals("츄로스")) {
            System.out.println("츄로스의 가격은 3000원 입니다.");
        }else if (food.equals("통감자")) {
            System.out.println("통감자의 가격은 2000원 입니다.");
        }else if (food.equals("도토리탕후루")) {
            System.out.println("도토리탕후루의 가격은 5000원 입니다.");
        }else{
            System.out.println("해당 상품이 판매하지 않습니다.");
        }
    }

}
