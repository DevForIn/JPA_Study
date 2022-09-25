//package com.example.hellospring.service;
//
//import javax.persistence.EntityManager;
//import javax.sql.DataSource;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import com.example.hellospring.repository.JpaMemberRepository;
//import com.example.hellospring.repository.MemberRepository;
//
//
//@Configuration
//public class SpringConfig {
//
//	private EntityManager em;
//	@Autowired
//	public SpringConfig(EntityManager em) {
//		this.em = em;
//	}
//		
//	@Bean
//	public MemberService memberService() {
//		return new MemberService(memberRepository());
//	}
//	
//	@Bean
//	public MemberRepository memberRepository() {
////		return new MemoryMemberRepository();
////		return new JdbcMemberRepository(dataSource);
////		return new JdbcTemplateMemberRepository(dataSource);
//		return new JpaMemberRepository(em); 
//	}
//}
