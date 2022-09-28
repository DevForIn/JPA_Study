package com.example.hellospring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.hellospring.domain.Member;
import com.example.hellospring.repository.MemberRepository;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class MemberService {

	@Autowired
	private MemberRepository memberRepository;
	
	@Transactional
	public List<Member> getMembers(){
		return memberRepository.findAll();
	}

	@Transactional
	public Member create(Member member) {
		return memberRepository.save(member);	
	}

	@Transactional
	public void delete(Long id) {
		memberRepository.deleteById(id);		
	}

	@Transactional
	public int update(Long id,Member updateMember) {
		Optional<Member> oMember = memberRepository.findById(id);
		if(oMember.isPresent())
			return 0;
		Member member = oMember.get();
		member.setAge(updateMember.getAge());
		member.setEmail(updateMember.getEmail());
		member.setName(updateMember.getName());
		return 1;
	}	
}
