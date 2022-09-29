package com.example.hellospring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.hellospring.domain.Member;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long>{
	
	Member findById(long id);
	
	List<Member> findAll();
	
	void deleteById(Long id);	
	
	@SuppressWarnings("unchecked")
	Member save(Member member);
		
}
