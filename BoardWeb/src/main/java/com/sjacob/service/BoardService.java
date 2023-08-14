package com.sjacob.service;

import org.springframework.data.domain.Page;

import com.sjacob.domain.Board;
import com.sjacob.domain.Search;

public interface BoardService {

	Page<Board> getBoardList(Search search);

	void insertBoard(Board board);

	Board getBoard(Board board);

	void updateBoard(Board board);

	void deleteBoard(Board board);

}