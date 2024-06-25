package com.ohgiraffers.section01.exception;

public class ExceptionTest {
	
	public void checkEnoughMoney(int price, int money) throws Exception{
		
		System.out.println("가지고 계신 돈은 " + money + "원 입니다.");
		
		if(money >= price) {
			System.out.println("상품을 구입하기 위한 금액이 충분합니다.");
		} else {

			System.out.println("상품을 구입하기 위한 금액이 충분하지 않습니다.");
			

			throw new Exception();
		}
		
		/* 설명. 예외가 발생하지 않는 경우에 실행한다. */
		System.out.println("즐거운 쇼핑 하세요~");
	}
}
