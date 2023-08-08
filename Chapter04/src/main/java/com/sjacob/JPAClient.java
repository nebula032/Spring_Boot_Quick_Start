package com.sjacob;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.sjacob.domain.Board;

public class JPAClient {

	public static void main(String[] args) {
		// EntityManager 생성
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Chapter04");
		EntityManager em = emf.createEntityManager();
		// Transaction 생성
		EntityTransaction tx = em.getTransaction();
		
		try {
			// Transaction 시작
			tx.begin();
			
			// 글 등록
//			Board board = new Board();
//			board.setTitle("JPA 제목");
//			board.setWrtier("작성자");
//			board.setContent("내용");
//			board.setCreateDate(new Date());
//			board.setCnt(0L);
//			
//			em.persist(board);
//			tx.commit();
			
			// 글 상세 조회
//			Board seacrchBoard = em.find(Board.class, 1L);
//			System.out.println("---> " + seacrchBoard);
			
			// 글 수정
//			Board board = em.find(Board.class, 1L);
//			board.setTitle("수정");
//			tx.commit();
			
			// 글 삭제
//			Board board1 = em.find(Board.class, 1L);
//			em.remove(board1);
//			tx.commit();
			
			// 글 목록 조회
			String jpql = "select b from Board b order by b.seq desc";
			List<Board> boardList = em.createQuery(jpql, Board.class).getResultList();
			for (Board board : boardList) {
				System.out.println("---> " + board);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			em.close();
			emf.close();
		}

	}

}
