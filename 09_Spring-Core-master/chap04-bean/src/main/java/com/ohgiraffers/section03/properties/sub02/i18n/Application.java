package com.ohgiraffers.section03.properties.sub02.i18n;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Date;
import java.util.Locale;

public class Application {

    /*
    * [ i18n ]
    * = 소프트웨어 국제화(Internationalization에서 첫 글자인 i와 마지막 글자인 n 사이 알파벳 갯수가 18개)
    * - 어떠한 특정 프레임워크를 지칭하는 것이 아닌 i와 n 사이에 18개의 알파벳이라는 뜻이다.
    * - 소프트웨어를 국제화 하기 위해서는 처리해야 하는 작업이 많다.
    *  1) 언어, 지역별 번역
    *  2) OS/플랫폼 인코딩
    *  3) 문자열 치환 방법
    *  4) 국제화 UI (문자열 크기 변화, 폰트, 아이콘 등)
    *  5) 쓰기 방향의 차이
    *  6) 숫자, 공백, 화폐, 날짜, 주소, 측정 단위 등
    *  7) 타임존, 섬머타임 등 시각
    *  8) 문자열 정렬 방법
    * */

    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(ContextConfiguration.class);

        String error404MsgKR = context.getMessage("error.404", null, Locale.KOREA);
        String error500MsgKR = context.getMessage("error.500", new Object[]{"토끼", new Date()}, Locale.KOREA);

        System.out.println("I18N error.404 메세지 : " + error404MsgKR);
        System.out.println("I18N error.500 메세지 : " + error500MsgKR);

        String error404MsgUS = context.getMessage("error.404", null, Locale.US);
        String error500MsgUS = context.getMessage("error.500", new Object[]{"you", new Date()}, Locale.US);

        System.out.println("The I18N message for error.404 : " + error404MsgUS);
        System.out.println("The I18N message for error.500 : " + error500MsgUS);

    }
}
