package com.example.StudySpringBoot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.StudySpringBoot.entity.Member;
import com.example.StudySpringBoot.service.MemberService;

import jakarta.transaction.Transactional;

@RestController
public class MemberController {
	@Autowired
	private MemberService memberService;
	
	@GetMapping("/member")
	public List<Member> getAllMembers() {
		return memberService.findAllMembers();
	}
	
	@Transactional
	@GetMapping("/member/{id}")
	public Member findMemberById(@PathVariable Long id) {
		Member member = memberService.findMemberById(id);
		System.out.println("Member Find : " + member);
		
		return member;
	}
	
	@PostMapping("/member")
    public Member createMember(@RequestBody Member member) {
        return memberService.saveMember(member);
    }
	
	@Transactional
	@PutMapping("/member/{id}")
    public ResponseEntity<Member> updateMember(@PathVariable Long id, @RequestBody Member memberDetails) {
		Member updateMember = memberService.updateMember(id, memberDetails);
        if (memberDetails != null) {
            return ResponseEntity.ok(updateMember);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
	
	@DeleteMapping("/member/{id}")
    public void deleteMember(@PathVariable Long id) {
        memberService.deleteMember(id);
    }
}
