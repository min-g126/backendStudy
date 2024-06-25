package com.ohgiraffers.section02.superkeyword;

import java.util.Date;

public class Computer extends Product {

    /* Computer는 하나의 Product이지만, 모든 Product는 Computer가 아니다. (IS-A) */

    private String cpu;
    private int hdd;
    private int ram;
    private String operationSystem;

    /* 기본생성자 */
    public Computer() {

        System.out.println("Computer 클래스의 기본 생성자 호출함...");

    }

    /* 모든 필드를 초기화하는 생성자 */
    public Computer(String cpu, int hdd, int ram, String operationSystem) {

        /* 부모클래스의 기본생성자 호출 */
        super();

        this.cpu = cpu;
        this.hdd = hdd;
        this.ram = ram;
        this.operationSystem = operationSystem;

        System.out.println("Computer 클래스의 모든 필드를 초기화하는 생성자 호출함...");
    }

    /* 부모의 필드도 모두 초기화하는 생성자 */
    public Computer(String code, String brand, String name, int price, Date manufacturingDate, 
                    String cpu, int hdd, int ram, String operationSystem) {
        
        /* 부모의 모든 필드를 초기화하는 생성자로 Product클래스가 가진 필드를 초기화할 값 전달 */
        super(code, brand, name, price, manufacturingDate);

        /* 나머지 필드를 초기화 */
//        this(cpu, hdd, ram, operationSystem);

        /* this()로 위에 작성한 생성자를 호출한다는 의미는
        *  super()를 두 번 호출하는 것과 같기 때문에 허용되지 않는다.
        *  부모 인스턴스를 두 개 생성할 수 없기 때문에 부모 생성자는 한 번만 호출 가능하다. */

        /* 나머지 필드는 그냥 작성함 */
        this.cpu = cpu;
        this.hdd = hdd;
        this.ram = ram;
        this.operationSystem = operationSystem;

        System.out.println("Computer 클래스의 부모 필드도 초기화하는 생성자 호출함...");
    }

    /* setter와 getter는 부모 필드의 메소드에 대해서는 자신의 것 처럼 사용 가능하다.
    *  따로 작성할 필요 없이 부모클래스에 작성한 것을 사용할 수 있다.
    *  따라서 자식클래스에 추가된 필드에 대해서만 setter/getter를 작성하면 된다. */
    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public int getHdd() {
        return hdd;
    }

    public void setHdd(int hdd) {
        this.hdd = hdd;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public String getOperationSystem() {
        return operationSystem;
    }

    public void setOperationSystem(String operationSystem) {
        this.operationSystem = operationSystem;
    }

    @Override
    public String getInformation() {

        /* 부모클래스에 작성한 getter를 이용해서 부모 필드가 가진 값도 한 번에 문자열 합치기 한다.
        *  부모가 가진 멤버는 super.과 this. 둘다 사용이 가능하다.
        *  하지만 코드의 의미를 명확하게 하기 위해 super.을 사용하는 것이 좋다.
        * */
//        return "Computer ["
//                + "code=" + super.getCode()
//                + ", brand=" + super.getBrand()
//                + ", name=" + super.getName()
//                + ", price=" + super.getPrice()
//                + ", manufacturingDate=" + super.getManufacturingDate()
//                + ", cpu=" + this.cpu
//                + ", hdd=" + this.hdd
//                + ", ram=" + this.ram
//                + ", operationSystem=" + this.operationSystem
//                +"]";

        return super.getInformation()
                + "Computer ["
                + "cpu=" + this.cpu
                + ", hdd=" + this.hdd
                + ", ram=" + this.ram
                + ", operationSystem=" + this.operationSystem
                + "]";
    }
}
