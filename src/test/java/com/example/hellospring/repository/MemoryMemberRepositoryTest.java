package com.example.hellospring.repository;


import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import com.example.hellospring.domain.Member;



public class MemoryMemberRepositoryTest{
	
	MemoryMemberRepository repository = new MemoryMemberRepository();
	
	@AfterEach
	public void afterEach() {
		repository.clearStore();
	}
	
	@Test
	public void save() {
		Member member = new Member();
		member.setName("Jeong In");
		
		repository.save(member);
		
		Member result = repository.findById(member.getId()).get();
		
//		System.out.println("result = " + (result == member));
		
		Assertions.assertThat(member).isEqualTo(result);
	}
	
	@Test
	public void findByName() {
		Member member1 = new Member();
		member1.setName("Roo");
		repository.save(member1);
		
		Member member2 = new Member();
		member2.setName("Loo");
		repository.save(member2);
		
		Member result = repository.findByName("Roo").get();
		
		assertThat(result).isEqualTo(member1);		
	}
	
	@Test
	public void findAll() {
		Member member1 = new Member();
		member1.setName("Roo");
		repository.save(member1);
		
		Member member2 = new Member();
		member2.setName("Loo");
		repository.save(member2);
		
		List<Member> result = repository.findAll();
		
		assertThat(result.size()).isEqualTo(2);
	}
}
