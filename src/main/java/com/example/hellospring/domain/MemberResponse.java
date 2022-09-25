package com.example.hellospring.domain;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
public class MemberResponse {
	
	private long id;
	private String name;
	private String email;
	private int age;
	 
	@Builder
	public MemberResponse(Long id,String name,String email,int age) {
		this.id=id;
		this.age=age;
		this.email=email;
		this.name=name;
	}

}
