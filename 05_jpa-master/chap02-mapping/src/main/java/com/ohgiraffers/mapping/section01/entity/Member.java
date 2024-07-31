package com.ohgiraffers.mapping.section01.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

/*
 * [ @Entity ]
 * 클래스 선언부 위에 위치해 JPA에서 사용되는 엔티티 클래스임을 표시 (해당 클래스와 데이터베이스의 테이블 매핑)
 * - `name` 속성을 사용하여 엔티티 클래스와 매핑될 테이블의 이름을 지정할 수 있다.
 *   (생략하면 자동으로 클래스 이름을 엔티티명으로 사용한다.)
 * - 프로젝트 내에 다른 패키지에도 동일한 엔티티가 존재하면, 해당 엔티티를 식별을 위해 중복되지 않는 name을 지정해야 한다.
 * - 기본 생성자는 필수로 작성해야 한다.
 * - final 클래스, enum, interface, inner class 에서는 사용할 수 없다.
 * - 저장할 필드에 final을 사용하면 안된다.
 * */

/*
* [ @Access - (1) Class Level ]
* 모든 필드에 대하여 필드 접근 방식을 적용
* - 필드 접근이 기본 값이므로 @Access(AccessType.FIELD) 설정은 제거해도 동일하게 동작한다.
* - 필드 레벨과 프로퍼티(메소드) 레벨에 모두 선언하면 프로퍼티 레벨을 우선으로 사용한다.
* - Getter 접근 방식(프로퍼티 방식) 설정 시 주의할 점은
*   @Id 어노테이션이 필드에 있다면 엔티티를 생성하지 못하므로
*   @Id 어노테이션을 getter 메소드 위로 옮겨야 한다.
* */



@Entity(name = "entityMember")
@Table(name = "tbl_member")
//@Access(AccessType.FIELD)
//@TableGenerator(
//        name = "member_seq_tbl_generator",
//        table = "tbl_my_sequences",
//        pkColumnValue = "my_seq_member_no"
//)
public class Member {

    /*
    * [ Primary key에는 @Id, @GeneratedValue ]
    * - @Id : 엔티티 클래스에서 primary key 역할을 하는 필드를 지정
    * - @GeneratedValue : primary key 값을 자동으로 생성할 수 있음
    *                     (데이터베이스마다 기본 키를 생성하는 방식이 서로 다름)
    *
    * [ @GeneratedValue 속성 ]
    * - strategy : 자동 생성 전략을 지정
    *              - GenerationType.IDENTITY : 기본 키 생성을 데이터베이스에 위임 (MySQL의 AUTO_INCREMENT)
    *              - GenerationType.SEQUENCE : 데이터베이스 시퀀스 객체 사용 (ORACLE의 SEQUENCE)
    *              - GenerationType.TABLE : 키 생성 테이블 사용
    *              - GenerationType.AUTO : 자동 선택 (MySQL이라면 IDENTITY, ORACLE이라면 SEQUENCE로 선택)
    * - generator : strategy 값을 GenerationType.TABLE로 지정한 경우 사용되는 테이블 이름을 지정
    * - initialValue : strategy 값을 GenerationType.SEQUENCE로 지정한 경우 시퀀스 초기값을 지정
    * - allocationSize : strategy 값을 GenerationType.SEQUENCE로 지정한 경우 시퀀스 증가치를 지정
    * */

    /*
     * [ @Column 속성 ]
     * 1. name : 매핑할 테이블의 컬럼 이름
     * 2. insertable : 엔티티 저장 시 필드 저장 여부 (default : true)
     * 3. updatable : 엔티티 수정 시 필드 수정 여부 (default : true)
     * 4. table : 엔티티와 매핑될 테이블 이름
     * 5. nullable : null값 허용 여부 설정 = not null 제약 조건에 해당 (default : true)
     * 6. unique : 컬럼의 유일성 제약 조건
     *             (두 개 이상 컬럼에 unique 제약 조건을 설정하기 위해서는 클래스 레벨에서 @Table의 uniqueConstraints 속성에 설정)
     * 7. columnDefinition : 직접 컬럼의 DDL을 지정
     * 8. length : 문자열 길이 = String 타입에서만 사용 (default : 255)
     * */
    @Id
    @Column(name = "member_no")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @GeneratedValue(strategy = GenerationType.TABLE, generator = "member_seq_tbl_generator")
    private int memberNo;


    /*
     * [ @Access - (2) Field Level ]
     * 해당 필드에 대하여 필드 접근 방식을 적용
     * */

//    @Access(AccessType.FIELD)
    @Column(name = "member_id", unique = true, nullable = false, columnDefinition = "varchar(10)")
    private String memberId;

    @Column(name = "member_pwd", nullable = false)
    private String memberPwd;

    @Column(name ="member_name")
    private String memberName;

    @Column(name ="phone")
    private String phone;

    @Column(name ="address", length = 900)
    private String address;

    @Column(name = "enroll_date")
//    @Temporal(TemporalType.DATE)  //java.util.Date 또는 java.util.Calendar에만 쓸 수 있음
    private LocalDateTime enrollDate;


    /*
    * [ @Enumerated ]
    * Enum 타입 매핑을 위해 사용
    * - EnumType.ORDINAL : Enum 타입을 순서로 매핑 (default)
    *                     ㄴ장점 : 데이터베이스에 저장되는 데이터의 크기가 작음
    *                     ㄴ단점 : 이미 저장된 enum의 순서를 변경할 수 없음
    * - EnumType.STRING : Enum 타입을 문자열로 매핑
    *                     ㄴ장점 : 저장된 enum의 순서가 바뀌거나 enum이 추가되어도 안전함
    *                     ㄴ단점 : 데이터베이스에 저장되는 데이터의 크기가 ordinal에 비해 큼
    * */

    @Column(name ="member_role")
    @Enumerated(EnumType.STRING)
    private MemberRole memberRole;

    @Column(name ="status", columnDefinition = "char(1) default 'Y'")
    private String status;

    protected Member() {}

    public Member(String memberId, String memberPwd, String memberName, String phone, String address, LocalDateTime enrollDate, MemberRole memberRole, String status) {
        this.memberId = memberId;
        this.memberPwd = memberPwd;
        this.memberName = memberName;
        this.phone = phone;
        this.address = address;
        this.enrollDate = enrollDate;
        this.memberRole = memberRole;
        this.status = status;
    }

    /*
     * [ @Access - (3) Method Level ]
     * 해당 값의 접근 방식만 getter로 변경
     * */
//    @Access(AccessType.PROPERTY)
//    public String getMemberName() {
//        System.out.println("getMemberName()을 이용한 Access 확인");
//
//        return memberName + "님";
//    }
//
//    public void setMemberName(String memberName) {
//        this.memberName = memberName;
//    }
}
