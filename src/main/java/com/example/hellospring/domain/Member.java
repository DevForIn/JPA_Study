 package com.example.hellospring.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@Entity(name = "Member")
public class Member {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID", nullable = false)
	private Long id;
	
	@Column(nullable = false)
	private String name;	
	
	@Column(name ="EMAIL")
	private String email;
	
	@Column(name = "AGE")
	private int age;
	
}
