package com.ohgiraffers.section01.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Map;

/* @Aspect : pointcut과 advice를 하나의 클래스 단위로 정의하기 위한 어노테이션 */
@Aspect
@Component
public class LoggingAspect {

    /*
    * [ @Pointcut ]
    * - 여러 Join point를 매치하기 위해 지정한 표현식
    *   execution([수식어] 리턴타입 [클래스이름].이름(파라미터))
    * - 수식어(접근제어자) 생략 가능 public private protected default
    * - 파라미터 표현 방식
    *   *(..) : 매개변수가 0개 이상인 모든 메소드
    *   *(*) : 매개변수가 1개인 모든 메소드
    *   *(*,..) : 매개변수가 1개 이상인 모든 메소드
    * */
    @Pointcut("execution(* com.ohgiraffers.section01.aop.*Service.*(..))")
    public void logPointcut() {}

    /*
    * [ JoinPoint ]
    * - Pointcut으로 패치한 실행 지점
    * - 매치된 JoinPoint에서 해야 할 일이 Advice
    * - 매개변수로 전달한 JoinPoint 객체는 현재 JoinPoint의 메소드명, 인수값 등 자세한 정보에 엑세스 할 수 있다.
    * */
    @Before("LoggingAspect.logPointcut()")
    public void logBefore(JoinPoint joinPoint) {
        System.out.println("[Before joinPoint.getTarget()] " + joinPoint.getTarget());
        System.out.println("[Before joinPoint.getSignature()] " + joinPoint.getSignature());
        if(joinPoint.getArgs().length > 0) {
            System.out.println("[Before joinPoint.getArgs()[0]] " + joinPoint.getArgs()[0]);
        }
    }

    /* Pointcut을 동일한 클래스 내에서 사용하는 경우 클래스명 생략 가능
    * 단, 같은 패키지 내 다른 클래스이면 클래스명 생략 불가하며
    * 다른 패키지이면 패키지를 포함한 클래스명을 기술해야 함 */
    @After("logPointcut()")
    public void logAfter(JoinPoint joinPoint) {
        System.out.println("[After joinPoint.getTarget()] " + joinPoint.getTarget());
        System.out.println("[After joinPoint.getSignature()] " + joinPoint.getSignature());
        if(joinPoint.getArgs().length > 0) {
            System.out.println("[After joinPoint.getArgs()[0]] " + joinPoint.getArgs()[0]);
        }
    }

    /* returning 속성은 return 값을 받아올 Object 매개변수 이름과 동일해야 하며
    * joinPoint는 반드시 첫 번째 매개변수로 선언해야 함 */
    @AfterReturning(pointcut = "logPointcut()", returning = "result")
    public void logAfterReturning(JoinPoint joinPoint, Object result) {
        System.out.println("[After Returning result] " + result);

        if(result != null && result instanceof Map) {
            ((Map<Long, MemberDTO>) result).put(100L, new MemberDTO(100L, "반환 값 가공"));
        }
    }

    /* throwing 속성은 예외 정보를 받아올 Throwable 매개변수 이름과 동일해야 함 */
    @AfterThrowing(pointcut = "logPointcut()", throwing = "exception")
    public void logAfterThrowing(JoinPoint joinPoint, Throwable exception) {
        System.out.println("[After Throwing exception] " + exception);
    }

    /* Around Advice는 가장 강력한 어드바이스이다.
    * 이 어드바이스는 JoinPoint를 완전히 장악하기 때문에
    * Before, After[returning, throwing] 어드바이스를 Around 어드바이스로 조합할 수 있다.
    * 심지어 원본 조인포인트를 언제 실행할지, 실행 자체의 여부까지도 제어한다.
    * (최소한의 요건을 충족하면서도 가장 기능이 약한 어드바이스를 사용하는 것이 바람직하다.) */
    @Around("logPointcut()")
    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("[Around Before] " + joinPoint.getSignature().getName());

        /* 원본 조인포인트 실행 */
        Object result = joinPoint.proceed();

        System.out.println("[Around After] " + joinPoint.getSignature().getName());

        /* 원본 조인포인트를 호출한 쪽 혹은 다른 어드바이스가 다시 실행할 수 있도록 반환 */
        return result;
    }

}
