package com.example.hellospring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.hellospring.domain.Member;

public interface QDRepository extends JpaRepository<Member,Long>{

}
