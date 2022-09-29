package com.example.hellospring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.hellospring.domain.Member;
import com.example.hellospring.repository.MemberRepositorySupport;
import com.example.hellospring.service.MemberService;




@RestController
public class MemberController{
	
	private final MemberService memberService;
	private final MemberRepositorySupport memberRepositorySuport;
	
	@Autowired
	public MemberController(MemberService memberService, MemberRepositorySupport memberRepositorySuport) {
		this.memberService = memberService;
		this.memberRepositorySuport = memberRepositorySuport;
	}
	
	
	// Member 전체 조회
	@GetMapping("/members")
	public List<Member> list() {
		List<Member> list = memberService.getMembers();
		return list;
	}
	
	// Member QClass 적용 사례
	@GetMapping("/QMembers/{name}")
	public List<Member> qList(String name) {
		return memberRepositorySuport.findByName(name);		
	}
	
	// Member 생성 Member.id = Auto increment
	@PostMapping("/members")
	public void create(Member member) {
		memberService.create(member);
	}
	
	// Member 수정 
	@PutMapping("/members/{id}")
	public void put(@PathVariable("id")Long id,Member member) {
		memberService.update(id,member);
	}
	
	// Member 삭제
	@DeleteMapping("/members/{id}")
	public void delete(Long id) {
		memberService.delete(id);
	}
}