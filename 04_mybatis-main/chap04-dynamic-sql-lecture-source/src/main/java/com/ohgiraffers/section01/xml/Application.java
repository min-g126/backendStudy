package com.ohgiraffers.section01.xml;

import com.ohgiraffers.common.SearchCriteria;

import java.util.*;

public class Application {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("============ MyBatis Dynamic SQL ============");
            System.out.println("1. if test");
            System.out.println("2. choose(when, otherwise) test");
            System.out.println("3. foreach test");
            System.out.println("4. trim(where, set) test");
            System.out.println("9. 프로그램 종료");
            System.out.println("실행할 메뉴 번호를 입력하세요 : ");
            int no = sc.nextInt();
            
            switch (no) {
                case 1: ifSubMenu(); break;
                case 2: chooseSubMenu(); break;
                case 3: foreachSubMenu(); break;
                case 4: trimSubMenu(); break;
                case 9: System.out.println("프로그램을 종료합니다."); return;
                
            }
        } while (true);

    }

    private static void ifSubMenu() {
        Scanner sc = new Scanner(System.in);
        MenuService menuService = new MenuService();

        do {
            System.out.println("============ if Sub Menu ============");
            System.out.println("1. 원하는 금액대에 적합한 추천 메뉴 목록 조회");
            System.out.println("2. 메뉴명 또는 카테고리명으로 검색한 메뉴 목록 조회");
            System.out.println("9. 이전 메뉴로 이동");
            System.out.println("실행할 메뉴 번호를 입력하세요 : ");
            int no = sc.nextInt();

            switch (no) {
                case 1: menuService.selectMenuByPrice(inputPrice()); break;
                case 2: menuService.searchMenu(inputSearchCriteria()); break;
                case 9: return;
            }
        } while (true);
    }


    private static int inputPrice() {
        Scanner sc = new Scanner(System.in);
        System.out.println("찾을 메뉴의 최대 금액을 입력하세요 : ");
        int price = sc.nextInt();

        return price;
    }

    private static SearchCriteria inputSearchCriteria() {
        Scanner sc = new Scanner(System.in);
        System.out.println("검색 기준을 입력하세요 (category 또는 menu) : ");
        String condition = sc.nextLine();
        System.out.println("검색어를 입력하세요 : ");
        String value = sc.nextLine();

        return new SearchCriteria(condition, value);
    }


    private static void chooseSubMenu() {
        Scanner sc = new Scanner(System.in);
        MenuService menuService = new MenuService();

        do {
            System.out.println("============ choose sub Menu ============");
            System.out.println("1. 카테고리 상위 분류별 메뉴 목록 조회");
            System.out.println("9. 이전 메뉴로 이동");
            System.out.println("실행할 메뉴 번호를 입력하세요 : ");
            int no = sc.nextInt();

            switch (no) {
                case 1: menuService.searchMenuBySupCategory(inputSupCategory()); break;
                case 9: return;
            }

        } while (true);

    }


    private static SearchCriteria inputSupCategory() {
        Scanner sc = new Scanner(System.in);
        System.out.println("상위 분류를 입력하세요 (식사 or 음료 or 디저트) : ");
        String value = sc.nextLine();

        return new SearchCriteria("supCategory", value);
    }


    private static void foreachSubMenu() {
        Scanner sc = new Scanner(System.in);
        MenuService menuService = new MenuService();

        do {
            System.out.println("============ foreach Sub Menu ============");
            System.out.println("1. 랜덤한 메뉴 5개 추출 조회");
            System.out.println("9. 이전 메뉴로 이동");
            System.out.println("실행할 메뉴 번호를 입력하세요 : ");
            int no = sc.nextInt();

            switch (no) {
                case 1: menuService.searchMenuByRandomMenuCode(createRandomMenuCodeList()); break;
                case 9: return;
            }
        } while (true);
    }

    public static List<Integer> createRandomMenuCodeList() {
        Set<Integer> set = new HashSet<>();
        while (set.size() < 5) {
            int temp = ((int) (Math.random() * 20) + 1);
            set.add(temp);
        }

        List<Integer> list = new ArrayList<>(set);
        Collections.sort(list);

        return list;
    }
    
    
    public static void trimSubMenu() {
        Scanner sc = new Scanner(System.in);
        MenuService menuService = new MenuService();

        do {
            System.out.println("============ trim Sub Menu ============");
            System.out.println("1. 검색 조건이 있으면 메뉴 코드로 목록 조회 (단, 없으면 전체 조회)");
            System.out.println("2. 메뉴명 또는 카테고리 코드로 검색한 목록 조회 " +
                    "(단, 메뉴명과 카테고리 모두 일치하는 경우도 검색 가능하고 검색 조건이 없으면 전체 조회)");
            System.out.println("3. 원하는 메뉴 정보만 수정");
            System.out.println("9. 이전 메뉴 이동");
            System.out.println("실행할 메뉴 번호를 입력하세요 : ");
            int no = sc.nextInt();

            switch (no) {
                case 1: menuService.searchMenuByCodeOrSearchAll(inputOneOrAll()); break;
                case 2: menuService.searchMenuByNameOrCategory(inputSearchCriteriaMap()); break;
                case 3: menuService.modifyMenu(inputChangeInfo()); break;
                case 9: return;
            }
        } while (true);
    }




    private static SearchCriteria inputOneOrAll() {
        Scanner sc = new Scanner(System.in);

        System.out.println("검색 조건을 입력하시겠습니까? (y or n) : ");
        boolean hasSearchValue = "y".equals(sc.nextLine())? true : false;

        SearchCriteria searchCriteria = new SearchCriteria();
        if (hasSearchValue) {
            System.out.println("검색한 메뉴 코드를 입력하세요 : ");
            String code = sc.nextLine();
            searchCriteria.setCondition("menuCode");
            searchCriteria.setValue(code);
        }
        return searchCriteria;
    }



    private static Map<String, Object> inputSearchCriteriaMap() {

        Scanner sc = new Scanner(System.in);

        System.out.println("검색 조건을 입력하세요 (menuName or category or both or null) : ");
        String condition = sc.nextLine();

        Map<String, Object> criteria = new HashMap<>();

        if ("menuName".equals(condition) || "both".equals(condition)) {
            System.out.println("검색할 메뉴명을 입력하세요 : ");
            String nameValue = sc.nextLine();

            criteria.put("nameValue", nameValue);
        }

        if ("category".equals(condition) || "both".equals(condition)) {
            System.out.println("검색할 카테고리 코드를 입력하세요 : ");
            int categoryValue = sc.nextInt();

            criteria.put("categoryValue", categoryValue);
        }

        return criteria;
    }

    private static Map<String, Object> inputChangeInfo() {

        Scanner sc = new Scanner(System.in);
        System.out.println("변경 대상 메뉴 코드를 입력하세요 : ");
        int code = sc.nextInt();
        System.out.println("변경할 메뉴 이름을 입력하세요 : ");
        sc.nextLine();
        String name = sc.nextLine();
        System.out.println("변경할 메뉴 가격을 입력하세요 : ");
        int price = sc.nextInt();
        System.out.println("변경할 카테고리 코드를 입력하세요 : ");
        int categoryCode = sc.nextInt();
        System.out.println("판매 여부를 결정해 주세요 (y or n) : ");
        sc.nextLine();
        String orderableStatus = sc.nextLine();

        Map<String, Object> criteria = new HashMap<>();
        criteria.put("code", code);
        criteria.put("name", name);
        criteria.put("price", price);
        criteria.put("categoryCode", categoryCode);
        criteria.put("orderableStatus", orderableStatus);

        return criteria;
    }
}
