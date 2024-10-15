package com.ohgiraffers.thymeleaf.controller;

import com.ohgiraffers.thymeleaf.model.dto.MemberDTO;
import com.ohgiraffers.thymeleaf.model.dto.SelectCriteria;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("lecture")
public class LectureController {

    @GetMapping("expression")
    public ModelAndView expression(ModelAndView mv) {

        mv.addObject("member", new MemberDTO("토끼", 20, '무', "서울시 노원구"));

        mv.addObject("hello", "hello <h3>Thymeleaf</h3>!");

        mv.setViewName("/lecture/expression");

        return mv;
    }

    @GetMapping("conditional")
    public ModelAndView conditional(ModelAndView mv) {

        mv.addObject("num", 216);
        mv.addObject("str", "바나나");

        List<MemberDTO> memberList = new ArrayList<>();
        memberList.add(new MemberDTO("이재혁", 25, '남', "서울시 노원구"));
        memberList.add(new MemberDTO("도영익", 25, '남', "삼육대 기숙사"));
        memberList.add(new MemberDTO("윤석용", 24, '남', "삼육대 에스라관"));
        memberList.add(new MemberDTO("김상익", 32, '남', "삼육대 1번지"));

        mv.addObject("memberList", memberList);


        mv.setViewName("/lecture/conditional");

        return mv;
    }

    @GetMapping("etc")
    public ModelAndView etc(ModelAndView mv) {

        SelectCriteria selectCriteria = new SelectCriteria(1, 10, 7);

        MemberDTO member = new MemberDTO("이재혁", 25, '남', "서울시");

        List<MemberDTO> memberList = new ArrayList<>();
        memberList.add(new MemberDTO("이재혁", 25, '남', "서울시 노원구"));
        memberList.add(new MemberDTO("도영익", 25, '남', "삼육대 기숙사"));
        memberList.add(new MemberDTO("윤석용", 24, '남', "삼육대 에스라관"));
        memberList.add(new MemberDTO("김상익", 32, '남', "삼육대 1번지"));

        Map<String, MemberDTO> memberMap = new HashMap<>();
        memberMap.put("m01", new MemberDTO("이재혁", 25, '남', "서울시 노원구"));
        memberMap.put("m02", new MemberDTO("도영익", 25, '남', "삼육대 기숙사"));
        memberMap.put("m03", new MemberDTO("윤석용", 24, '남', "삼육대 에스라관"));
        memberMap.put("m04", new MemberDTO("김상익", 32, '남', "삼육대 1번지"));


        mv.addObject(selectCriteria);
        mv.addObject("member", member);
        mv.addObject("memberList", memberList);
        mv.addObject("memberMap", memberMap);

        mv.setViewName("/lecture/etc");

        return mv;
    }

    @GetMapping("fragment")
    public ModelAndView fragment(ModelAndView mv) {

        mv.addObject("test1", "value1");
        mv.addObject("test2", "value2");

        mv.setViewName("/lecture/fragment");

        return mv;
    }
}
