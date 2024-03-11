package me.study.springbootdeveloper.Service;

import me.study.springbootdeveloper.DAO.Member;
import me.study.springbootdeveloper.Repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TestService {

    @Autowired
    MemberRepository memberRepository;

    public List<Member> getAllMembers(){
        System.out.println(getClass().getName() + "getAllMembers 시작!!");
        return memberRepository.findAll();  // 멤버 목록 얻기
    }
}