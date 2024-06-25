package com.ohgiraffers.section03.wrapper;

public class Application1 {

	public static void main(String[] args) {

		/* [ Wrapper 클래스 ]
		 * (기본타입)      (Wrapper클래스)
		 *  byte          Byte
		 *  short         Short
		 *  int           Integer
		 *  long          Long
		 *  float         Float
		 *  double        Double
		 *  char          Character
		 *  boolean       Boolean
		 * */

		/*
		 * [ Boxing & UnBoxing ]
		 * 기본타입을 Wrapper클래스의 인스턴스로 인스턴스화 하는 것을 박싱(Boxing)이라고 하며,
		 * Wrapper클래스 타입의 인스턴스를 기본 타입으로 변경하는 것을 언박싱(UnBoxing)이라고 한다.
		 * */
		int intValue = 900;
//        Integer boxingNum = new Integer(intValue);        // 생성자를 사용하는 방식은 Deprecated 되어 있다.
		Integer boxingNum1 = Integer.valueOf(intValue);

		/*
		 * [ Deprecated ]
		 *  향후 버전이 업데이트 되면서 사라질 예정인 기능이니 가급적이면 사용을 권장하지 않는다는 의미이다.
		 *  하지만 하위 버전과의 호환성 때문에 갑자기 제거된 것은 아니고, 우선은 남겨두었기 때문에 사용은 가능하다.
		 * */

		int unboxingNum1 = boxingNum1.intValue();

		/*
		 * [ AutoBoxing & AutoUnBoxing ]
		 *  JDK 1.5부터는 박싱과 언박싱이 필요한 상황에서 자바 컴파일리가 이를 자동으로 처리해준다.
		 *  이렇게 자동화된 박싱과 언박싱을 오토박싱, 오토언박싱 이라고 부른다.
		 * */

		Integer boxingNum2 = intValue;
		int unboxingNum2 = boxingNum2;

		int inum = 900;
		Integer integerNum1 = Integer.valueOf(900);
		Integer integerNum2 = Integer.valueOf(900);
		Integer integerNum3 = 900;
		Integer integerNum4 = 900;

		/* 기본 타입과 래퍼클래스 타입은 == 연산으로 비교 가능하다. */
		System.out.println("inum == integerNum1 : " + (inum == integerNum1));
		System.out.println("inum == integerNum3 : " + (inum == integerNum3));

		/* 인스턴스의 경우 ==로 비교하지 못한다. */
		System.out.println("integerNum1 == integerNum2 : " + (integerNum1 == integerNum2));
		System.out.println("integerNum2 == integerNum4 : " + (integerNum2 == integerNum4));
		System.out.println("integerNum3 == integerNum4 : " + (integerNum3 == integerNum4));
		System.out.println(Integer.valueOf(900) == Integer.valueOf(900));

		/* Wrapper 클래스 타입의 인스턴스를 비교할 때는 equals()를 사용해야 한다. */
		System.out.println(integerNum1.equals(integerNum2));

	}

}
