package com.ohgiraffers.section01.exception;

public class Application1 {

	public static void main(String[] args) throws Exception {

		
		/* 목차. 1. throws로 위임 */
		ExceptionTest et = new ExceptionTest();

		/* 설명. 상품 가격은 10000원이고, 가진 돈은 50000원인 경우 */
//		et.checkEnoughMoney(10000, 50000);		//정상 동작한다.
		
		/* 설명. 상품 가격은 50000원이고, 가진 돈은 10000원인 경우 */
		et.checkEnoughMoney(50000, 10000);		//예외 발생 구문 이하 구문은 동작하지 않고 종료된다.

		System.out.println("프로그램을 종료합니다.");
	}
}
