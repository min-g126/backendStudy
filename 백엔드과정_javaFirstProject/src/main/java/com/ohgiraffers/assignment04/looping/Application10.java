package com.ohgiraffers.assignment04.looping;

import java.util.Scanner;

public class Application10 {

    public static void main(String[] args) {

        /* 어떤 문장의 각 알파벳을 일정한 거리만큼 밀어서
         * 다른 알파벳으로 바꾸는 암호화 방식을 시저 암호라고 합니다.
         *
         * A를 3만큼 밀면 D가 되고, z를 1만큼 밀면 a가 됩니다.
         * 또한 공백문자는 변경되지 않습니다.
         *
         * 문자열 1개를 입력 받고,
         * 얼만큼 문자를 밀지 알려주는 0보다 큰 정수를 1개 입력 받아
         * 암호문을 작성하는 프로그램을 만들어 보세요.
         * 단, 숫자가 27인 경우는 1칸을 밀게 됩니다. (알파벳은 26글자이기 때문입니다.)
         *
         * -- 입력 예시 --
         * 문자열을 입력하세요 : a B z
         * 숫자를 입력하세요 : 4
         *
         * -- 출력 예시 --
         * e F d
         *
         * -- 입력 예시 --
         * 문자열을 입력하세요 : a B z
         * 숫자를 입력하세요 : 27
         *
         * -- 출력 예시 --
         * b C a
         * */

        Scanner sc = new Scanner(System.in);
        System.out.println("문자열을 입력하세요.");
        String str = sc.nextLine();
        System.out.println("숫자를 입력하세요.");
        int num = sc.nextInt();

        //최종 암호화 초기화
        String finalStr = "";

        for(int i = 0; i<str.length();i++){
            //string 을 하나씩 쪼개기
            char strChar = str.charAt(i);

            //대문자 영문자 암호화
            if(Character.isUpperCase(strChar)){
                //입력받은 문자에서 A를 빼서 몇번쨰 문자인지 알아보고 이동시킬 거리 계산
                finalStr +=(char)((strChar - 'A'+num)%26+'A');

                //소문자 영문자 암호화
            } else if (Character.isLowerCase(strChar)) {
                finalStr += (char)((strChar - 'a' + num)%26 + 'a');
            }else{
                finalStr += strChar; //알파벳이 아니면 그대로 추가
            }
        }

        //최종 암호 출력
        System.out.println(finalStr);

    }

}
