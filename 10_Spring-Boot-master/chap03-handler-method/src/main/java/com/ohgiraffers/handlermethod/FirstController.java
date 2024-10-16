package com.ohgiraffers.handlermethod;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.context.request.WebRequest;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Map;

@Controller
@RequestMapping("/first/*")
@SessionAttributes("id")
public class FirstController {

    /* /first/regist => templates/first/regist.html*/
    @GetMapping("regist")
    public void regist() {
    }


    /* 1. WebRequest로 요청 파라미터 전달 받기 */
    @PostMapping("regist")
    public String registMenu(Model model, WebRequest request) {

        String name = request.getParameter("menuName");
        int price = Integer.parseInt(request.getParameter("price"));
        int categoryCode = Integer.parseInt(request.getParameter("categoryCode"));

        String message = name + "을(를) 신메뉴 목록의 " + categoryCode + "번 카테고리에 " + price + "원으로 등록 하였습니다!";

        model.addAttribute("message", message);

        return "first/messagePrinter";
    }

    @GetMapping("modify")
    public void modify() {
    }

    /* 2. @RequestParam 이용하여 요청 파라미터 전달 받기 */
    @PostMapping("modify")
    public String modifyMenu(Model model,
                             @RequestParam(required = false) String modifyName,
                             @RequestParam(defaultValue = "0") int modifyPrice) {

        String message = modifyName + " 메뉴의 가격을" + modifyPrice + "원으로 변경 하였습니다.";

        model.addAttribute("message", message);

        return "first/messagePrinter";
    }

    @PostMapping("modifyAll")
    public String modifyMenuByMap(Model model, @RequestParam Map<String, String> parameters) {

        String modifyName = parameters.get("modifyNameAll");
        int modifyPrice = Integer.parseInt(parameters.get("modifyPriceAll"));

        String message = modifyName + " 메뉴의 가격을 " + modifyPrice + "원으로 변경 하였습니다";

        model.addAttribute("message", message);

        return "first/messagePrinter";
    }

    @GetMapping("search")
    public void search() {
    }

    /* 3. @ModelAttribute 이용하여 요청 파라미터 커맨드 객체로 전달 받기 */
    @PostMapping("search")
    public String searchMenu(@ModelAttribute("menuInfo") MenuDTO menu) {

        System.out.println(menu);

        return "first/searchResult";
    }

    @GetMapping("login")
    public void login() {
    }

    /* 4. session 이용하기 */
    /* 4-1. HttpSession을 배개변수로 선언하여 메소드 호출 시 세션 객체를 넣어서 호출 */
    @PostMapping("login1")
    public String sessionTest1(HttpSession session, @RequestParam String id) {

        session.setAttribute("id", id);

        return "first/loginResult";
    }

    @GetMapping("logout1")
    public String logoutTest1(HttpSession session) {

        session.invalidate();

        return "first/loginResult";
    }

    /* 4-2. @SessionAttributes를 이용하여 session에 값 담기
     *       클래스 레벨에 @SessionAttributes 어노테이션을 이용하여 세션에 담을 key 값을 설정하면
     *       Model 영역에 해당 key로 attribute가 추가되는 경우 세션에 자동 등록함
     * */
    @PostMapping("login2")
    public String sessionTest2(Model model, @RequestParam String id) {

        model.addAttribute("id", id);

        return "first/loginResult";
    }

    @GetMapping("logout2")
    public String logoutTest2(SessionStatus sessionStatus) {

        /* SessionAttributes로 등록된 값은 session의 상태를 관리하는 SessionStatus의
         * setComplete() 메소드를 호출해야 사용이 만료되며,
         * setComplete() 메소드는 세션에 저장된 모든 정보를 제거함(개별 제거 불가) */
        sessionStatus.setComplete();

        return "first/loginResult";
    }

    @GetMapping("body")
    public void body() {
    }

    /* 5. @RequestBody 이용하여 요청 정보 전달 받기 */
    @PostMapping("body")
    public void bodyTest(@RequestBody String body,
                         @RequestHeader("content-type") String contentType,
                         @CookieValue(value="JSESSIONID", required = false) String sessionId) throws UnsupportedEncodingException {

        System.out.println(body);
        System.out.println(contentType);
        System.out.println(sessionId);
        System.out.println(URLDecoder.decode(body, "UTF-8"));

    }
}
