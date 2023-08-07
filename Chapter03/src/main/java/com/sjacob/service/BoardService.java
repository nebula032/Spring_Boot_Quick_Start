package com.sjacob.service;

import java.util.List;

import com.sjacob.BoardVO;

public interface BoardService {

	String hello(String name);
	
	BoardVO getBoard();
	
	List<BoardVO> getBoardList();
}
