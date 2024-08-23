package com.example.StudySpringBoot.repository;

import java.util.List;
import java.util.Optional;

import com.example.StudySpringBoot.domain.Member;

public interface MemberRepository {
	Member save(Member Member);
	Optional<Member> findById(Long id);
	Optional<Member> findByName(String name);
	List<Member> findAll();
}
