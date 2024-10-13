package com.ohgiraffers.section02.reflection;

import java.lang.reflect.*;

public class Application {
    
    /*
    *[ reflection ]
    * 컴파일된 자바 코드에서 역으로 클래스를 불러 method 및 field 정보를 구해오는 방법으로,
    * 반사, 투명이라는 의미를 가진다.
    * 리플렉션은 JVM에서 실행되는 애플리케이션의 런타임 동작을
    * 검사하거나 수정할 수 있는 기능이 필요한 경우 사용한다.
    * SpringFramework, MyBatis, Hibernate, jackson 등의 라이브러리에서 사용하며,
    * Spring에서는 Reflection을 사용해서 런타임 시
    * 개발자가 등록한 bean을 애플리케이션 내에서 사용할 수 있게 한다.
    * 
    * [ 주의사항 ]
    * Reflection은 강력한 도구이지만 무분별하게 사용해서는 안된다.
    * 1. 오버헤드 발생 : 성능 저하를 발생시킬 수 있으므로 성능에 민감한 애플리케이션에서는 사용하지 않는다.
    * 2. 캡슐화 저해  : private로 설정한 멤버에 접근 가능하므로 코드 기능이 저하되며 여러 문제를 발생시킬 수 있다.
    * 
    * [ Reflection이 사용되는 경우 ]
    * 1. IoC Container
    * 2. AOP
    * 3. Mybatis Mapper
    * 4. log4jdbc
    *  */

    public static void main(String[] args) {

        /* Class : 해당 클래스의 메타 정보를 가지고 있는 클래스 */
        /* 1) .class 문법을 이용하여 Class 타입의 인스턴스를 생성할 수 있다. */
        Class class1 = Account.class;
        System.out.println("[class1] " + class1);

        /* 2) Object 클래스의ㅏ getClass() 메소드를 이용하면 Class 타입으로 리턴받아 이용할 수 있다.*/
        Class class2 = new Account().getClass();
        System.out.println("[class2] " + class2);

        try {
            /* 3) Class.forName() 메소드를 이용하여 런타임 시 로딩하고 해당 클래스 메타 정보를 Class 타입으로 반환받을 수 있다. */
            Class class3 = Class.forName("com.ohgiraffers.section02.reflection.Account");
            System.out.println("[class3] " + class3);

            /* Double 자료형 배열을 로드할 수 있다. */
            Class class4 = Class.forName("[D");
            Class class5 = double[].class;
            System.out.println("[class4] " + class4);
            System.out.println("[class5] " + class5);

            /* String 자료형 배열을 로드할 수 있다. */
            Class class6 = Class.forName("[Ljava.lang.String;");
            Class class7 = String[].class;
            System.out.println("[class6] " + class6);
            System.out.println("[class7] " + class7);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        /* 원시 자료형의 Class 타입은 얻을 수 없다. (컴파일 에러 발생 ) */

//        double d = 1.0;
//        Class class8 = d.getClass();

        /* TYPE 필드를 이용하여 원시형 클래스를 반환받을 수 있다. */
        Class class8 = Double.TYPE;
        System.out.println("[class8] " + class8);

        Class class9 = Void.TYPE;
        System.out.println("[class9] " + class9);

        /* 클래스의 메타 정보를 이용하여 여러 정보를 반환받는 메소드를 제공한다. */
        /* getSuperClass() 메소드는 상속된 부모 클래스를 반환한다. */
        Class superClass = class1.getSuperclass();
        System.out.println("[superClass] " + superClass);
        
        /* 필드 정보 */
        System.out.println("============== Field ==============");
        Field[] fields = Account.class.getDeclaredFields();
        for (Field field : fields) {
            System.out.println("modifiers : " + Modifier.toString(field.getModifiers())
                                + ", type : " + field.getType()
                                + ", name : " + field.getName() );
        }

        /* 생성자 정보 */
        System.out.println("============== Constructor ==============");
        Constructor[] constructors = Account.class.getConstructors();
        for (Constructor constructor : constructors) {
            System.out.println("name : " + constructor.getName());

            Class[] params = constructor.getParameterTypes();
            for (Class param : params) {
                System.out.println("paramType : " + param.getTypeName());

            }
        }

        try {
            Account acc = (Account) constructors[1].newInstance("20", "110-234-567890", "0000", 10000);
            System.out.println(acc);

        } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }

        /* 메소드 정보 */
        System.out.println("============== Method ==============");
        Method[]  methods = Account.class.getMethods();
        Method toStringMethod = null;

        for (Method method : methods) {
            System.out.println(Modifier.toString(method.getModifiers())
                                + " " + method.getReturnType().getSimpleName()
                                + " " + method.getName());

            Class[] params = method.getParameterTypes();
            for (Class param : params) {
                System.out.println("paramType : " + param.getTypeName());
            }

            if ("toString".equals(method.getName())) {
                toStringMethod = method;
            }
        }

        try {
            System.out.println(toStringMethod.invoke((Account) constructors[1].newInstance("20", "110-234-567890", "0000", 10000)));

        } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
