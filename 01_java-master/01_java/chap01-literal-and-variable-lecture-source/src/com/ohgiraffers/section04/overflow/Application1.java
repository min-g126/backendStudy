package com.ohgiraffers.section04.overflow;

public class Application1 {

    public static void main(String[] args) {
        
        /* 오버플로우 */
        /* 자료형 별 값의 최대 범위를 벗어나는 경우 
        * 발생한 carry를 버림처리 하고 sign bit를 반전시켜 최소값으로 순환시킴
        * */
        
        byte num1 = 127;

        System.out.println("num1 : " + num1);
        
        num1++;

        System.out.println("num1 overflow : " + num1);
        
        /* 언더플로우 */
        /* 오버플로우와 반대 개념으로 최소 범위보다 작은 수를 발생시키는 경우 발생하는 현상이다.*/
        
        byte num2 = -128;

        System.out.println("num2 underflow : " + num2);

        num2--;

        System.out.println("num2 underflow : " +num2);
        
        /* 이러한 오버플로우와 언더플로우가 발생한다고 하여 컴파일 에러나 런타임 에러가 발생하지 않는다. 
        * 그렇기에 최대값 혹은 최소값 범위를 고려해서 코드를 작성해야 한다. 
        * */
        
        /* 일반적으로 많이 사용하는 int형의 최대값은 대략 21억 정도이다. 
        * 이 범위를 벗어난 계산은 오버플로우를 발생시켜서 원하지 않는 결과값이 나오게 될 수 있다.
        * */
        int firstNum = 1000000;
        int secondNum = 700000;
        
        int multi = firstNum * secondNum;

        System.out.println("firstNum * secondNum = " + multi);
        
        /* 이런 현상이 발생해도 그냥 넘기는 경우가 발생할 수 있다. 
        * 이런 경우를 논리적 에러라고 표현한다.*/
        
        /* 해결방법 */
        /* 오버플로우를 예측하고 더 큰 자료형으로 결과값을 받아서 처리한다. */
        long longMulti = firstNum * secondNum;

        System.out.println("longMulti : " + longMulti);
        
        /* 이미 오버플로우 처리된 결과를 가지고 변수에 담기 때문에 위에 결과와 별 차이는 없다.
        * */
        long result = (long) firstNum * secondNum;

        System.out.println("result : " + result);
        
    }
}
