package com.sjacob.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sjacob.domain.Member;
import com.sjacob.persistence.MemberRepository;

@Service
public class MemberServiceImpl implements MemberService {
	@Autowired
	private MemberRepository memberRepo;
	
	@Override
	public Member getMember(Member member) {
		Optional<Member> findMember = memberRepo.findById(member.getId());
		if (findMember.isPresent()) {
			return findMember.get();
		} else {
			return null;
		}
	}
}
