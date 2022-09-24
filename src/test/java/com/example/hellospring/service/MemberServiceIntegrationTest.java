package com.example.hellospring.service;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

import com.example.hellospring.domain.Member;
import com.example.hellospring.repository.MemberRepository;


@SpringBootTest
@Transactional
class MemberServiceIntegrationTest {
	
	@Autowired MemberService memberService;
	@Autowired MemberRepository memberRepository;
	
	@Test
	@Commit
	void 회원가입() {
		//given
		Member member = new Member();
		member.setName("spring");
		
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

	}

	@Test
	void 모든회원찾기() {
		
	}

	@Test
	void 하나회원찾기() {
		
	}

}