package com.sjacob.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.querydsl.core.BooleanBuilder;
import com.sjacob.domain.Board;
import com.sjacob.domain.QBoard;
import com.sjacob.domain.Search;
import com.sjacob.persistence.BoardRepository;

@Service
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	private BoardRepository boardRepo;
	
	public Page<Board> getBoardList(Search search) {
		BooleanBuilder builder = new BooleanBuilder();
		QBoard qboard = QBoard.board;
		if (search.getSearchCondition().equals("TITLE")) {
			builder.and(qboard.title.like("%" + search.getSearchKeyword() + "%"));
		} else if (search.getSearchCondition().equals("CONTENT")) {
			builder.and(qboard.content.like("%" + search.getSearchKeyword() + "%"));
		}
		Pageable pageable = PageRequest.of(0, 10, Sort.Direction.DESC, "seq");
		return boardRepo.findAll(builder, pageable);
	}
	 
	public void insertBoard(Board board) {
		boardRepo.save(board);
	}
	
	public Board getBoard(Board board) {
		return boardRepo.findById(board.getSeq()).get();
	}
	
	public void updateBoard(Board board) {
		Board findBoard = boardRepo.findById(board.getSeq()).get();
		
		findBoard.setTitle(board.getTitle());
		findBoard.setContent(board.getContent());
		boardRepo.save(findBoard);
	}
	
	public void deleteBoard(Board board) {
		boardRepo.deleteById(board.getSeq());
	}

}
