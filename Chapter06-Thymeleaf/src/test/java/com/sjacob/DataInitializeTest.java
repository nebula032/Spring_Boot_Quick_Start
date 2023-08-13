package com.sjacob;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.sjacob.domain.Board;
import com.sjacob.domain.Member;
import com.sjacob.persistence.BoardRepository;
import com.sjacob.persistence.MemberRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DataInitializeTest {
	@Autowired
	private MemberRepository memberRepo;
	
	@Autowired
	private BoardRepository boardRepo;
	
	@Test
	public void testDataInsert() {
		Member member1 = new Member();
		member1.setId("member1");
		member1.setName("민규");
		member1.setPassword("member111");
		member1.setRole("ROLE_USER");
		memberRepo.save(member1);
		
		Member member2 = new Member();
		member2.setId("member2");
		member2.setName("지영");
		member2.setPassword("member222");
		member2.setRole("ROLE_ADMIN");
		memberRepo.save(member2);
		
		for (int i = 1; i <= 3; i++) {
			Board board = new Board();
			board.setTitle("민규 제목" + i);
			board.setWriter("민규");
			board.setContent("민규 내용" + i);
			boardRepo.save(board);
		}
		
		for (int i = 4; i <= 6; i++) {
			Board board = new Board();
			board.setTitle("지영 제목" + i);
			board.setWriter("지영");
			board.setContent("지영 내용" + i);
			boardRepo.save(board);
		}
	}
}
