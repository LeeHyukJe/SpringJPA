package com.wisenut.ichattool;

import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.hyukje.domain.Board;
import com.hyukje.domain.QBoard;
import com.hyukje.persistence.BoardRepository;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.victolee.guestbook.domain.GuestBook;
import com.victolee.guestbook.service.GuestBookService;

import lombok.extern.java.Log;

@Log
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml",
"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
@WebAppConfiguration
public class RepositoryTests {
	
	@Autowired
	private GuestBookService bookService;
	
	@Autowired
	private BoardRepository boardRepo;
	
	@Autowired
	private EntityManager entityManager;

	@Before
	public void initMocks() {
		MockitoAnnotations.initMocks(this); // mock all the field having @Mock annotation
	}
	
	@Test
	public void test200Insert() throws Exception{
		for(int i=0;i<=200;i++) {
			Board board = new Board();
			board.setTitle("제목..."+i);
			board.setContent("내용..."+i);
			board.setWriter("user0"+(i%10));
			boardRepo.save(board);
		}
		
	}

	@Test
	public void test() throws Exception{
		GuestBook book = new GuestBook();
		book.setMessage("hello");
		book.setName("홍길동");
		book.setPwd("111");
		bookService.insertMessage(book);
	}
	
	@Test
	public void test2() throws Exception{
		Board board = new Board();
		board.setTitle("게시글의 제목");
		board.setContent("게시물 내용 넣기");
		board.setWriter("user00");
		
		boardRepo.save(board);
	}
	
	@Test
	public void test3() throws Exception{
		boardRepo.findBybno(1L).ifPresent(board->{
			log.info(board.toString());
		});
	}
	
	@Test
	public void 수정작업테스트() throws Exception{
		Board board = boardRepo.findOne(1L);
		board.setTitle("수정된 제목으로 바꾸고 싶어요");
		
		boardRepo.save(board);
	}
	
	@Test
	public void 삭제테스트() throws Exception{
		boardRepo.delete(1L);
	}
	
	@Test
	public void 쿼리메소드테스트() throws Exception{
		boardRepo.findAll().forEach(board->{
			log.info(board.toString());
		});
	}
	
	@Test
	public void 쿼리메소드테스트2() throws Exception{
		boardRepo.findByWriterContaining("user")
			.forEach(board->log.info(board.toString()));;
	}
	
	@Test
	public void 쿼리메소드부등호테스트() throws Exception{
		boardRepo.findByBnoLessThanAndBnoGreaterThan(3L, 1L)
			.ifPresent(board->log.info(board.toString()));
	}
	
	@Test
	public void 쿼리메소드OrderBy테스트() throws Exception{
		boardRepo.findByBnoLessThanAndBnoGreaterThanOrderByBnoDesc(3L, 1L)
		.ifPresent(board->log.info(board.toString()));
	}
	
	@Test
	public void 쿼리메소드Paging테스트() throws Exception{
		Pageable paging = new PageRequest(0,10);
		boardRepo.findByBnoLessThanAndBnoGreaterThanOrderByBnoDesc(3L, 1L, paging)
		.forEach(board->log.info(board.toString()));
	}
	
	@Test
	public void 쿼리메소드Page테스트() throws Exception{
		Pageable paging = new PageRequest(0,10);
		Page<Board> result = boardRepo.findByBnoGreaterThanEqualOrderByBnoDesc(1L, paging);
		System.out.println("PAGE SIZE: " + result.getSize());
		System.out.println("PAGE SIZE: " + result.getTotalPages());
		System.out.println("PAGE SIZE: " + result.getTotalElements());
		System.out.println("PAGE SIZE: " + result.nextPageable());
		
		List<Board> list = result.getContent();
		list.forEach(board->log.info(board.toString()));
	}
	
	@Test
	public void Query테스트() throws Exception{
		boardRepo.findByTitle("17")
			.forEach(board->log.info(board.toString()));
	}
	
	@Test
	public void QueryTest2() throws Exception{
		boardRepo.findByTitle2("17")
		.forEach(arr->log.info(Arrays.toString(arr)));
	}
	@Test
	public void QueryPageTest() throws Exception{
		Pageable pageagle = new PageRequest(0,10);
		boardRepo.findByPage(pageagle)
		.forEach(board->log.info(board.toString()));
	}
	
	@Test
	public void QuerydslTest() throws Exception{
		JPAQueryFactory query = new JPAQueryFactory(entityManager);
		QBoard board = QBoard.board;
		long list = query.selectFrom(board)
				.select(board.writer)
				.where(board.bno.gt(1))
				.where(board.bno.lt(10))
				.groupBy(board.writer)
				.fetchCount();
		//list.forEach(b->log.info(b.toString()));
		System.out.println(list);
	}
}
