package com.ohgiraffers.section01.aop;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class MemberDAO {

    private final Map<Long, MemberDTO> memberMap;

    public MemberDAO() {
        memberMap = new HashMap<>();
        memberMap.put(1L, new MemberDTO(1L, "호랑이"));
        memberMap.put(2L, new MemberDTO(2L, "토끼"));
    }

    public Map<Long, MemberDTO> selectAllMembers() {
        return memberMap;
    }

    public MemberDTO selectMemberById(Long id) {
        MemberDTO returnMember = memberMap.get(id);

        if (returnMember == null) {
            throw new RuntimeException("해당 id의 회원이 존재하지 않습니다.");
        }

        return returnMember;
    }
}
