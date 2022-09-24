package com.example.hellospring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

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
	
//	@GetMapping("/")
//	public String home() {
//		return "home";
//	}
	
	@GetMapping("/")
	public ResponseEntity<?> list() {
		List<Member> memberList = memberService.findMembers();
 		return ResponseEntity.status(HttpStatus.OK).body(memberList);
		
	}
	
//	@PostMapping("/members/new")
//	public Member create(String name) {
//		
//		Member member = new Member(); 
//		
//		
//		System.out.println("Member = "+member.getName());
//		
//		member = memberService.join(member);
//		
//		return member;
//	}
	
	@GetMapping("/members/delete")
	public String delete() {
		return "members/deleteMemberForm";
	}
	
	@DeleteMapping("/members/delete/{name}")
	public String deleteUser(@PathVariable("name") String name) {		
		
		memberService.deleteByName(name);
	
		return "members/deleteMemberForm";
	}
	
	@GetMapping("/members")
	public String list(Model model) { 
		List<Member> members = memberService.findMembers();
		model.addAttribute("members",members);
		
		return "members/memberList";
	}
}