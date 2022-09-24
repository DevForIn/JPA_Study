package com.example.hellospring.service;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.hellospring.domain.Member;
import com.example.hellospring.repository.MemoryMemberRepository;


class MemberServiceTest {
	
	MemberService memberService;
	MemoryMemberRepository memberRepository;
	
	
	@BeforeEach
	public void beforeEach() {
		memberRepository = new MemoryMemberRepository();
		memberService = new MemberService(memberRepository);
	}
	
	
	@AfterEach
	public void afterEach() {
		memberRepository.clearStore();
	}
	
	@Test
	void 회원가입() {
		//given
		Member member = new Member();
		member.setName("hello");
		
		//when
		Long saveId = memberService.join(member);
		
		//then
		Member findMember = memberService.findOne(saveId).get();
		assertThat(member.getName()).isEqualTo(findMember.getName());
	}
	
	@Test
	void 중복회원예외() {
		//given
		Member member1 = new Member();
		member1.setName("Spring");
		
		Member member2 = new Member();
		member2.setName("Spring");
		//when
		memberService.join(member1);		
		IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member1));
		assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원");
		/*
		 * try { memberService.join(member2); fail("예외가 발생해야 합니다."); }
		 * catch(IllegalStateException e){
		 * assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원"); }
		 */
		
		//then
	}

	@Test
	void 모든회원찾기() {
		
	}

	@Test
	void 하나회원찾기() {
		
	}

}