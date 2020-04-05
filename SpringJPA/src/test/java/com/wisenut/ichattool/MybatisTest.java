package com.wisenut.ichattool;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import com.hyukje.domain.Board;
import com.hyukje.domain.Criteria;
import com.hyukje.persistence.BoardDAO;

import lombok.extern.java.Log;

@Log
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml",
"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
@WebAppConfiguration
public class MybatisTest {
	
	
	@Autowired
	private BoardDAO boardDAO;
	
	@Before
	public void initMocks() {
		MockitoAnnotations.initMocks(this); // mock all the field having @Mock annotation
	}
	
	
	@Test
	public void daoTest() throws Exception{
		List<Board> list  =  boardDAO.listPage(3);
		list.stream().forEach(each->log.info(each.getBno()+":"+each.getTitle()));
	}
	
	@Test
	public void testListCriteria() throws Exception{
		Criteria cri = new Criteria();
		cri.setPage(2);
		cri.setPerPageNum(20);
		
		List<Board> list = boardDAO.listCriteria(cri);
		
		list.stream().forEach(each->log.info(each.getBno()+":"+each.getTitle()));
	}
	
	@Test
	public void testUrlBuilder() throws Exception{
		UriComponents uriComponenets = UriComponentsBuilder.newInstance()
				.path("/{module}/{page}")
				.queryParam("bno", 12)
				.queryParam("perPageNum",20)
				.build()
				.expand("sss","ddd")
				.encode();
		
		log.info(uriComponenets.toString());
	}

}
