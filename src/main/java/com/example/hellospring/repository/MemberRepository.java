package com.example.hellospring.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.hellospring.domain.Member;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long>{
	
	//
	Member save(Member member);
	
	Optional<Member> findById(Long id);
	
	Optional<Member> findByName(String name);
	
	List<Member> findAll();

	Optional<Member> deleteByName(String name);	
	
}
