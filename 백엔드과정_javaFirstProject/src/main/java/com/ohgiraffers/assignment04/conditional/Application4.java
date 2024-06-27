package com.ohgiraffers.assignment04.conditional;

import java.util.Scanner;

public class Application4 {

    public static void main(String[] args) {

        /* 축제에서 무료로 건강 검진을 해주는 부스로 이동했어요.
         *
         * 키와 몸무게를 실수(double)로 입력받아 BMI(신체질량지수)를 계산하고,
         * 계산된 값에 따라
         * 저체중(20 미만)인 경우 "저체중입니다. 축제 음식을 왕창 드세요!",
         * 정상체중(20이상 25미만)인 경우 "정상 체중입니다. 축제 재미있게 즐기세요~",
         * 과제충(25이상 30미만)인 경우 "축제에서 10,000보를 걷고 오시면 상품을 드려요!",
         * 비만(30이상)인 경우 "댄싱 부스에 참가하시고 도장을 받아오시면 선물을 드려요!"를  출력하세요.
         *
         * BMI 계산 방법은 체중(kg) / (신장(m) * 신장(m)) 입니다.
         * 계산 예시) BMI = 67 / (1.7 * 1.7)
         *
         * -- 입력 예시 --
         * 키를 입력해 주세요(m) : 1.7
         * 체중을 입력해 주세요(kg) : 67
         *
         * -- 출력 예시 --
         * 정상 체중입니다. 축제 재미있게 즐기세요~
         * */

        Scanner sc = new Scanner(System.in);
        System.out.println("키를 입력해 주세요(m)");
        double height = sc.nextDouble();
        System.out.println("체중을 입력해 주세요(kg)");
        double weight = sc.nextDouble();

        double Bmi = weight/(height*height);

        if(Bmi < 20){
            System.out.println("저체중입니다. 축제 음식을 왕창 드세요!");
        } else if (Bmi >= 20 && Bmi <25) {
            System.out.println("정상 체중입니다. 축제 재미있게 즐기세요~");
        }else if(Bmi >= 25 && Bmi <30){
            System.out.println("축제에서 10,000보를 걷고 오시면 상품을 드려요!");
        }
        else{
            System.out.println("댄싱 부스에 참가하시고 도장을 받아오시면 선물을 드려요!");
        }


    }

}
