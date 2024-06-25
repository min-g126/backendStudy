package com.ohgiraffers.section02.assignment_operator;

public class Application1 {

    public static void main(String[] args) {

        /* 대입연산자와 산술 복합 대입 연산자 */
        /* '=' : 왼쪽의 피연산자에 오른쪽의 피연산자를 대입함
        /* '+=' : 왼쪽의 피연산자에 오른쪽의 피연산자를 더한 결과를 왼쪽의 피연산자에 대압함
        /* '-=+' : 왼쪽의 피연산자에 오른쪽의 피연산자를 뺀 결과를 왼쪽의 피연산자에 대입함
        /* '*=' : 왼쪽의 피연산자에 오른쪽의 피연산자를 곱한 결과를 왼쪽의 피연산자에 대입함
        /* '/=' : 왼쪽의 피연산자에 오른쪽의 피연산자를 나눈 결과를 왼쪽의 피연산자에 대입함
        /* '%=' : 왼쪽의 피연산자에 오른쪽의 피연산자를 나눈 나머지 결과를 왼쪽의 피연산자에 대입함
        * */
        int num = 12;
        System.out.println("num : " + num);

        num = num + 3;
        System.out.println("num = " + num);

        num = 3;
        System.out.println("num = " + num);

        num -= 5;
        System.out.println("num = " + num);

        num *= 2;
        System.out.println("num = " + num);

        num /= 2;
        System.out.println("num = " + num);

        /* 주의! 산술 복합 대입연산자의 작성 순서에 주의해야 한다. */
        num =- 5;
        System.out.println("num = " + num);
    }
}
