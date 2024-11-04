package com.example.StudySpringBoot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.StudySpringBoot.entity.Member;
import com.example.StudySpringBoot.repository.MemberRepository;

@Service
public class MemberService  {
	@Autowired
	private MemberRepository memberRepository;
	
	public Member saveMember(Member member) {
		return memberRepository.save(member);
	}
	
	public List<Member> findAllMembers(){
		return memberRepository.findAll();
	}
	
	public Member findMemberById(Long id) {
		return memberRepository.findById(id).orElse(null);
	}
	
	// Update
    public Member updateMember(Long id, Member memberDetails) {
        Optional<Member> memberOptional = memberRepository.findById(id);
        if (memberOptional.isPresent()) {
            Member member = memberOptional.get();
            member.setName(memberDetails.getName());
            member.setAddress(memberDetails.getAddress());
  
            return memberRepository.save(member);
        } else {
            return null;
        }
    }
	
    public void deleteMember(Long id) {
    	memberRepository.deleteById(id);
    }
}
