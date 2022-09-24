package com.example.hellospring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.hellospring.domain.Member;
import com.example.hellospring.service.MemberService;


@Controller
public class MemberController{
	
	private MemberService memberService;
	
	// 의존 관계 추가 
	@Autowired
	public MemberController(MemberService memberService) {
		this.memberService = memberService;
	} 
	
	
	@GetMapping("/members/new")
	public String createFomr() {
		return "members/createMemberForm";
	}
	
	@PostMapping("/members/new")
	public String create(MemberForm form) {
		
		Member member = new Member(); 
		member.setName(form.getName());
		
		System.out.println("Member = "+member.getName());
		
		memberService.join(member);
		
		return "redirect:/";
	}
	
	@GetMapping("/members")
	public String list(Model model) { 
		List<Member> members = memberService.findMembers();
		model.addAttribute("members",members);
		
		return "members/memberList";
	}
}