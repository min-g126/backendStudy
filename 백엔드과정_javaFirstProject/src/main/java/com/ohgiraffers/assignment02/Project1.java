package com.ohgiraffers.assignment02;

import java.util.Scanner;

public class Project1 {

    public static void main(String[] args) {

        /*
         * 토까가 당근 홀짝 게임에 참여했습니다.
         * 당근 갯수를 선언하고,
         * 선언한 당근 갯수가 짝수이면 "짝이군!",
         * 짝수가 아니면 "홀이군!"을 출력하세요.
         *
         * ------- 출력 결과 화면 ----------
         * 예) 정수 7를 선언한 경우
         *
         * 홀이군!
         * */
    }
    public static void method1(){
        Scanner sc = new Scanner(System.in);
        System.out.println("당근 갯수를 입력해주세요 : ");
        int num = sc.nextInt();

        if(num %2 == 0 ){
            System.out.println("짝이군!");
        }else{
            System.out.println("홀이군!");
        }
    }

}
