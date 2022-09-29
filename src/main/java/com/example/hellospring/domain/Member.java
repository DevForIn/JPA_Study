 package com.example.hellospring.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity @Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="Member")
public class Member {	
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID", nullable = false)
	private Long id;
	
	@Column(nullable = false)
	private String name;		
	private String email;	
	private int age;
	
	@Builder
	public Member(String name, String email, int age) {
		this.name = name;
		this.email = email;
		this.age = age;
	}
}
