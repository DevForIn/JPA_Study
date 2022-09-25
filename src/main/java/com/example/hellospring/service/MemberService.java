//package com.example.hellospring.service;
//
//import java.util.List;
//import java.util.Optional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.transaction.annotation.Transactional;
//
//import com.example.hellospring.domain.Member;
//import com.example.hellospring.repository.MemberRepository;
//
//@Transactional
//public class MemberService {
//	
//	private MemberRepository memberRepository;
//	
//	@Autowired
//	public MemberService(MemberRepository memberRepository) {
//		this.memberRepository = memberRepository;
//	}
//	
//	// 회원가입
//	public Member join(Member member) {
//		Member newMember = member;
//		// 같은 이름이 있는 중복 회원 X
//		validateDuplicateMember(member);
//		 
//		newMember = memberRepository.save(member);
//		return newMember;
//	}
//	
//	// 전체 회원 조회
//	public List<Member> findMembers(){
//		return memberRepository.findAll();
//	}
//	
//	// 특정 아이디 회원 조회 
//	public Optional<Member> findOne(Long memberId){
//		return memberRepository.findById(memberId);
//	}
//
//	// 특정 아이디의 회원삭제 
//	public Optional<Member> deleteByName(String name) {
//		return memberRepository.deleteByName(name);
//		
//	}
//	
//	private void validateDuplicateMember(Member member) {
//		memberRepository.findByName(member.toString())
//			.ifPresent(m -> {
//				throw new IllegalStateException("이미 존재하는 회원");
//			});
//	}
//}
