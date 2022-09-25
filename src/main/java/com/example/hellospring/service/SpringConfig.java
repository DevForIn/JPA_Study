//package com.example.hellospring.service;
//
//import javax.persistence.EntityManager;
//import javax.sql.DataSource;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import com.example.hellospring.repository.MemberRepository;
//
//
//@Configuration
//public class SpringConfig {
//
//    private final MemberRepository memberRepository;
//
//    public SpringConfig(MemberRepository memberRepository) {
//        this.memberRepository = memberRepository;
//    }
//    @Bean
//    public MemberService memberService() {
//        return new MemberService(memberRepository);
//    }
//}
