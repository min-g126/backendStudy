package com.ohgiraffers.practice02.constructor;

import com.ohgiraffers.common.MemberDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class MemberService {
    @Autowired
    private MemberDAO memberDAO;
    public Map<Long, MemberDTO> selectMember() {
        return memberDAO.selectMember();
    }
}

