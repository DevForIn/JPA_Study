package com.example.hellospring.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.hellospring.domain.Member;
import com.example.hellospring.repository.MemberRepository;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class MemberService {

	private MemberRepository memberRepository;
	
	@Transactional
	public List<Member> getMembers(){
		return memberRepository.findAll();
	}
	
	
}
