package com.example.hellospring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import com.example.hellospring.domain.Member;
import com.example.hellospring.domain.QMember;
import com.querydsl.jpa.impl.JPAQueryFactory;

import lombok.NonNull;

@Repository
public class MemberRepositorySupport extends QuerydslRepositorySupport {
	private final JPAQueryFactory queryFactory;
		
	public MemberRepositorySupport(JPAQueryFactory queryFactory) {
		super(Member.class);
		this.queryFactory = queryFactory;
	}
	
	@NonNull
	public List<Member> findByName(String name){
		return queryFactory.selectFrom(QMember.member)
				.where(QMember.member.name.eq(name))
				.fetch();
	}
}
