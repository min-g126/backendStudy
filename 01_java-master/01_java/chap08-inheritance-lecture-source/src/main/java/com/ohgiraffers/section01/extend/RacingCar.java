package com.ohgiraffers.section01.extend;

public class RacingCar extends Car {

    /* 1. extends 키워드를 이용하여 Car 클래스 상속 */

    /* 기본생성자 */
    public RacingCar() {

        System.out.println("RacingCar 클래스 기본 생성자 호출됨...");
    }

    /* 2. run() 오버라이딩 */
    @Override
    public void run() {
        System.out.println("레이싱카가 전속력으로 질주합니다!!!!!!!!!!!!!!!!!!!");

        /* 실행해보면 경적이 울리지 않는다.
        *  Car 클래스의 run()메소드를 이용해서 private 필드인 runningStatus 상태를 변경했었는데
        *  RacingCar에서는 이걸 변경할 수 없기 때문에
        *  달리는 상태로 바꿀 수 없어서 경적을 울릴 수 없게 되는 것이다.
        * */

    }

    /* 3. soundHorn(), stop() 오버라이딩 */
    @Override
    public void soundHorn() {

        /* 레이싱카는 경적을 울리지 않는다. */
        System.out.println("레이싱카는 경적을 울리지 않습니다. (조용...)");
    }

    @Override
    public void stop() {

        /* 레이싱카도 멈추는 동작을 할 수 있다. */
        System.out.println("레이싱카가 멈춥니다.");
    }
}
