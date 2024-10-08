package com.ohgiraffers.section03.annotconfig.sub01.java;

import com.ohgiraffers.common.MemberDAO;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration("configurationSection03")
@ComponentScan(basePackages = "com.ohgiraffers")

/* excludeFilters 설정 */
//@ComponentScan(basePackages = "com.ohgiraffers",
//                excludeFilters = {
//                    @ComponentScan.Filter(
                            /* 1. 타입으로 설정 */
//                            type = FilterType.ASSIGNABLE_TYPE,
//                            classes = { MemberDAO.class }
                            /* 2. 어노테이션 종류로 설정 */
//                            type = FilterType.ANNOTATION,
//                            classes = { org.springframework.stereotype.Component.class }
                            /* 3. 표현식으로 설정 */
//                            type = FilterType.REGEX,
//                            pattern = {"com.ohgiraffers.section03.annotconfig.java.*"}
//                    )
//                })


/* includeFilters 설정 (+ useDefaultFilters 설정) */
//@ComponentScan(basePackages = "com.ohgiraffers",
//                useDefaultFilters = false,
//                includeFilters = {
//                    @ComponentScan.Filter(
//                            type = FilterType.ASSIGNABLE_TYPE,
//                            classes = { MemberDAO.class }
//                    )
//                })

public class ContextConfiguration {

    /*
    * @ComponentScan
    * base package로 설정된 하위 경로에 특정 어노테이션을 가진 클래스를 bean으로 등록하는 기능
    * basePackages를 설정하지 않으면 기본적으로 설정 파일과 동일한 패키지에 있는 bean만 탐색
    * @Component 어노테이션이 작성된 클래스를 인식하여 bean으로 등록
    * (특수 목적에 따라 세부 기능을 제공하는 @Controller, @Service, @Repository,
    * @Configuration 등을 사용하기도 함) */
}
