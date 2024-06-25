package com.ohgiraffers.section01.method;

public class Application9 {

    public static void main(String[] args) {

        /* 다른 클래스에 작성한 메소드를 호출할 수 있다. */
        /* 다른 클래스에 작성한 메소드 호출 */
        /* 동일한 패키지에 Calculator라는 클래스를 하나 추가하고 메소드를 작성해서 테스를 해 보자
        * 먼저 Calculator.java를 생성하고 메소드를 작성하고 다시 돌아오자!!
        * 두 값이 동일한 경우는 존재하지 않는다고 가정한다.
        * */

        /* 최대값 최솟값을 비교할 두 정수를 변수로 선언 */
        int first = 100;
        int second = 50;

        /* non-static 메소드의 경우 */
        /* 클래스가 다르더라도 사용하는 방법은 동일하다
        * 클래스명 사용할 이름 =  new 클래스명();
        * 사용할이름.메소드명();
        * */
        Calculator calc = new Calculator();
        int min = calc.minNumberOf(first, second);

        System.out.println("두 수 중 최소값은 : " + min);

        /* static 메소드인 경우 */
        /* 다른 클래스에 작성한 static 메소드의 경우 호출할 때 클래스명을 반드시 기술해야 한다.
        * 클래스명.메소드명();*/

//        int max = maxNumberOf(first, second);
//        int max = Calculator.maxNumberOf(first, second);
//
//        System.out.println("두 수 중 최대값은 : " + max);

        /* 주의사항.
        * static 메소드도 non-static 메소드처럼 호출은 가능하다.
        * 하지만 권장하지 않는다.
        * 이미 메모리에 로딩되어 있는 static 메소드는 여러 객체가 공유하게 된다.
        * 그 때 객체로 접근하게 되면 인스턴스가 가진 값으로 공유된 값에 예상히 못하는 동작을 유발할 수 있기 때문에
        * 사용을 제한해 달라는 경우다. 시스템이 복잡해질 수록 객체의 상태를 추적하기 어려워 유지보수에 악영향을 준다. */

        int max = calc.maxNumberOf(first, second);

        System.out.println("두 수 중 더 큰 값은 : " + max);

    }
}
