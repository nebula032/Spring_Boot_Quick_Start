package com.sjacob;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sjacob.domain.BoardVO;

@RestController
public class BoardController {

	public BoardController() {
		System.out.println("===> BoardController 생성");
	}
	
	@GetMapping("/hello")
	public String hello(String name) {
		return "Hello : " + name;
	}
	
	@GetMapping("getBoard")
	public BoardVO getBorad() {
		BoardVO board = new BoardVO();
		board.setSeq(1);
		board.setTitle("스프링부트");
		board.setWriter("boot");
		board.setContent("테스트입니다");
		board.setRegDate(new Date());
		board.setCnt(0);
		return board;
	}
	
	@GetMapping("getBoardList")
	public List<BoardVO> getBoradList() {
		List<BoardVO> boardList = new ArrayList<BoardVO>();
		for (int i = 1; i <= 10; i++) {
			BoardVO board = new BoardVO();
			board.setSeq(i);
			board.setTitle("스프링부트" + i);
			board.setWriter("boot" + i);
			board.setContent("테스트입니다");
			board.setRegDate(new Date());
			board.setCnt(0);
			boardList.add(board);
		}
		return boardList;
	}
	
}
