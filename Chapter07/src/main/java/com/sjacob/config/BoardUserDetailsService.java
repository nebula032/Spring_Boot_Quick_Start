package com.sjacob.config;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.sjacob.domain.Member;
import com.sjacob.persistence.MemberRepository;

@Service
public class BoardUserDetailsService implements UserDetailsService {

	@Autowired
	private MemberRepository memberRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println("BoardUserDetailsService : username : " + username);
		Optional<Member> optional = memberRepo.findById(username);
		if (!optional.isPresent()) {
			System.out.println("BoardUserDetailsService 사용자 없음");
			throw new UsernameNotFoundException(username + " 사용자 없음");
		} else {
			System.out.println("BoardUserDetailsService 사용자 있음");
			return new SecurityUser(optional.get());
		}
	}

}
