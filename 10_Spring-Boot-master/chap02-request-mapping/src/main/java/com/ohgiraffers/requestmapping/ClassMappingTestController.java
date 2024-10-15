package com.ohgiraffers.requestmapping;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/order/*")
public class ClassMappingTestController {

    /* 1. Class 레벨 매핑 */
    @GetMapping("/regist")
    public String registOrder(Model model) {

        model.addAttribute("message", "GET 방식의 주문 등록용 핸들러 메소드 호출");

        return "mappingResult";
    }

    /* 2. 여러 개의 패턴 매핑 */
    @RequestMapping(value = {"modify", "delete"}, method = RequestMethod.POST)
    public String modifyAndDelete(Model model) {

        model.addAttribute("message", "POST 방식의 주문 수정 및 삭제 공통 처리용 메소드 호출");

        return "mappingResult";
    }

    /* 3. path variable */
    /*
     * @PathVariable 어노테이션을 이용해 요청 path로부터 변수를 받아올 수 있다.
     * path variable로 전달 되는 {변수명} 값은 반드시 매개변수명과 동일해야 한다.
     * 만약 동일하지 않으면 @PathVariable("이름") 을 설정해주어야 한다.
     * */
    @GetMapping("/detail/{orderNumber}")
    public String selectOrderDetail(Model model, @PathVariable("orderNumber") int orderNo) {

        model.addAttribute("message", orderNo + "번 주문 상세 내용 조회용 핸들러 메소드 호출");

        return "mappingResult";
    }

    /* 4. 그 외의 다른 요청 */
    @RequestMapping
    public String otherRequest(Model model) {

        model.addAttribute("message", "order 요청이지만 다른 기능은 준비되지 않았음...");

        return "mappingResult";
    }
}
