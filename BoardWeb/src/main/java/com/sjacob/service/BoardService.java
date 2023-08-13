package com.sjacob.service;

import org.springframework.data.domain.Page;

import com.sjacob.domain.Board;

public interface BoardService {

	Page<Board> getBoardList(Board board);

	void insertBoard(Board board);

	Board getBoard(Board board);

	void updateBoard(Board board);

	void deleteBoard(Board board);

}