package com.example.hellospring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.hellospring.domain.Member;
import com.example.hellospring.repository.MemberRepository;


@RestController
public class MemberController{
	
	@Autowired
	MemberRepository memberRepository;
	
	
	@GetMapping("/members")
	public List<Member> members() {
		List<Member> list = memberRepository.findAll();
		return list;
	}
	
	@PostMapping("/members")
	public String memberCreate(@RequestBody Member member){	
		Member newMember = memberRepository.save(member);
		return newMember.toString();
	}
	
	@DeleteMapping("/members/delete/{name}")
	public String deleteUser(@PathVariable("name") String name) {		
		
		return "members/deleteMemberForm";
	}
}