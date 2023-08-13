package com.sjacob.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.sjacob.domain.Member;
import com.sjacob.service.MemberServiceImpl;

@SessionAttributes("member")
@Controller
public class LoginController {
	
	@Autowired
	private MemberServiceImpl memberService;

	@GetMapping("/login")
	public void loginView() {
	}
	
	@PostMapping("/login")
	public String login(Member member, Model model) {
		Member findMember = memberService.getMember(member);
		
		if (findMember != null && findMember.getPassword().equals(member.getPassword())) {
			System.out.println("로그인 성공");
			model.addAttribute("member", findMember);
			return "forward:getBoardList";
		} else {
			System.out.println("로그인 실패");
			return "redirect:login";
		}
	}
	
	@GetMapping("/logout")
	public String logout(SessionStatus status) {
		status.setComplete();
		return "redirect:index.html";
	}
}
