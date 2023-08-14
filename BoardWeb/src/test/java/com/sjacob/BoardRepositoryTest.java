package com.sjacob;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import com.sjacob.domain.Board;
import com.sjacob.domain.Member;
import com.sjacob.domain.Role;
import com.sjacob.persistence.BoardRepository;
import com.sjacob.persistence.MemberRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BoardRepositoryTest {
	
	@Autowired
	private MemberRepository memberRepo;
	
	@Autowired
	private BoardRepository boardRepo;
	
	@Autowired
	private PasswordEncoder encoder;
	
	@Test
	public void testInsert() {
		Member member1 = new Member();
		member1.setId("member");
		member1.setName("민규");
		member1.setPassword(encoder.encode("member123"));
		member1.setRole(Role.ROLE_MEMBER);
		member1.setEnabled(true);
		memberRepo.save(member1);
		
		Member member2 = new Member();
		member2.setId("admin");
		member2.setName("지영");
		member2.setPassword(encoder.encode("admin123"));
		member2.setRole(Role.ROLE_ADMIN);
		member2.setEnabled(true);
		memberRepo.save(member2);
		
		for (int i = 1; i <= 13; i++) {
			Board board = new Board();
			board.setMember(member1);
			board.setTitle(member1.getName() + " 제목 " + i);
			board.setContent(member1.getName() + " 내용 " + i);
			boardRepo.save(board);
		}
		
		for (int i = 1; i <= 3; i++) {
			Board board = new Board();
			board.setMember(member2);
			board.setTitle(member2.getName() + " 제목 " + i);
			board.setContent(member2.getName() + " 내용 " + i);
			boardRepo.save(board);
		}
	}
	
//	@Test
//	public void testGetBoard() {
//		Board board = boardRepo.findById(1L).get();
//		
//		System.out.println("[ " + board.getSeq() + "번 게시글 ]");
//		System.out.println("제목 : " + board.getTitle());
//		System.out.println("작성자 : " + board.getMember().getName());
//		System.out.println("내용 : " + board.getContent());
//		System.out.println("등록일 : " + board.getCreateDate());
//		System.out.println("조회수 : " + board.getCnt());
//		
//	}
	
//	@Test
//	public void testGetMember() {
//		Member member = memberRepo.findById("member").get();
//		
//		System.out.println("[ " + member.getName() + " 등록 글 ]");
//		for (Board board : member.getBoardList()) {
//			System.out.println(board.toString());
//			
//		}
//	}

}
