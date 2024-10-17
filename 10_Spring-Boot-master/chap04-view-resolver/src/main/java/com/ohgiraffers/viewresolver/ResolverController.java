package com.ohgiraffers.viewresolver;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/*")
public class ResolverController {

    @GetMapping("string")
    public String stringReturning(Model model) {

        model.addAttribute("forwardMessage", "문자열로 view 이름 반환");

        return "result";
    }

    @GetMapping("string-redirect")
    public String stringRedirect() {

        return "redirect:/";
    }

    @GetMapping("string-redirect-attr")
    public String stringRedirectFlashAttribute(RedirectAttributes rttr) {

        /* redirect 시에는 재요청이 발생하므로 request scope는 소멸된다.
         *  따라서 Model에 담아서 값을 전달할 수 없다. */
//        model.addAttribute("flashMessage1", "redirect model message");

        /* redirect 시 flash 영역에 값을 담아서 redirect 할 수 있다.
         *  단, 세션에 임시로 값을 담았다가 소멸하는 방식이므로 세션에 동일한 키 값이 존재하지 않아야 한다. */
        rttr.addFlashAttribute("flashMessage1",
                "redirect flash message (string return)");

        return "redirect:/";
    }

    @GetMapping("modelandview")
    public ModelAndView modelAndViewReturning(ModelAndView mv) {

        mv.addObject("forwardMessage", "ModelAndView로 Model과 View 반환");
        mv.setViewName("result");

        return mv;
    }

    @GetMapping("modelandview-redirect")
    public ModelAndView modelAndViewRedirect(ModelAndView mv) {

        mv.setViewName("redirect:/");

        return mv;
    }

    @GetMapping("modelandview-redirect-attr")
    public ModelAndView modealAndViewRedirectFlashAttr(ModelAndView mv, RedirectAttributes rttr) {

//        mv.addObject("flashMessage2", "redirect model message");
        rttr.addFlashAttribute("flashMessage2",
                "redirect flash message (ModelAndView return)");
        mv.setViewName("redirect:/");

        return mv;
    }
}
