package com.example.StudySpringBoot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.StudySpringBoot.entity.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {

}
