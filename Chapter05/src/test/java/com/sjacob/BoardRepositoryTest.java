package com.sjacob;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.sjacob.domain.Board;
import com.sjacob.persistence.BoardRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BoardRepositoryTest {
	@Autowired
	private BoardRepository boardRepo;
	
	// 글 등록
	@Test
	public void testInsertBoard() {
		System.out.println(">>> 글 등록 <<<");
		Board board = new Board();
		board.setTitle("제목1");
//		board.setWriter("작성자1");
		board.setContent("내용1");
		board.setCreateDate(new Date());
		board.setCnt(0L);
		
		boardRepo.save(board);
	}
	
	// 글 상세 조회
	@Test
	public void testGetBoard() {
		System.out.println(">>> 글 상세 조회 <<<");
		Board board = boardRepo.findById(1L).get();
		System.out.println(board.toString());
	}
	
	// 글 수정
	@Test
	public void testUpdateBoard() {
		System.out.println(">>> 글 수정 <<<");
		System.out.println("=== 1번 게시글 조회 ===");
		Board board = boardRepo.findById(1L).get();
		
		System.out.println("=== 1번 게시글 제목 수정 ===");
		board.setTitle("제목 수정");
		boardRepo.save(board);
	}
	
	// 글 삭제
	@Test
	public void testDeleteBoard() {
		System.out.println(">>> 글 삭제 <<<");
		boardRepo.deleteById(1L);
	}

}
