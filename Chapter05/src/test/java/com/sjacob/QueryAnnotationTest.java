package com.sjacob;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import com.sjacob.domain.Board;
import com.sjacob.persistence.BoardRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class QueryAnnotationTest {
	@Autowired
	private BoardRepository boardRepo;
	
//	@Test
//	public void testQueryAnnotationTest1() {
////		List<Board> boardList = boardRepo.queryAnnotationTest1_1("17");
//		List<Board> boardList = boardRepo.queryAnnotationTest1_2("17");
//		
//		System.out.println("검색 결과");
//		for (Board board : boardList) {
//			System.out.println("---> " + board.toString());
//		}
//	}
	
//	@Test
//	public void testQueryAnnotationTest2() {
//		List<Object[]> boardList = boardRepo.queryAnnotationTest2("17");
//		
//		System.out.println("검색 결과");
//		for (Object[] board : boardList) {
//			System.out.println("---> " + Arrays.toString(board));
//		}
//	}
	
//	@Test
//	public void testQueryAnnotationTest3() {
//		List<Object[]> boardList = boardRepo.queryAnnotationTest3("17");
//		
//		System.out.println("검색 결과");
//		for (Object[] board : boardList) {
//			System.out.println("---> " + Arrays.toString(board));
//		}
//	}
	
	@Test
	public void testQueryAnnotationTest4() {
		Pageable paging = PageRequest.of(0, 5, Sort.Direction.DESC, "seq");
		
		List<Board> boardList = boardRepo.queryAnnotationTest4(paging);
		
//		System.out.println("PAGE SIZE : " + pageInfo.getSize());
//		System.out.println("TOTAL PAGES : " + pageInfo.getTotalPages());
//		System.out.println("TOTAL COUNT : " + pageInfo.getTotalElements());
//		System.out.println("NEXT : " + pageInfo.nextPageable());
		
//		List<Board> boardList = pageInfo.getContent();
		
		System.out.println("검색 결과");
		for (Board board : boardList) {
			System.out.println("---> " + board.toString());
		}
	}

}
