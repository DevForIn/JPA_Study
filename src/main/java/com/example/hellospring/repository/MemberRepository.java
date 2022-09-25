package com.example.hellospring.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.hellospring.domain.Member;
import com.example.hellospring.domain.MemberResponse;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long>{
	
	Member findById(long id);
	List<Member> findAll();
	void deleteById(Long id);	
}
