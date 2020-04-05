package com.hyukje.service;

import java.util.List;

import com.hyukje.domain.Board;
import com.hyukje.domain.Criteria;

public interface BoardService {
	
	public void regist(Board vo) throws Exception;
	public Board read(Long bno) throws Exception;
	public void modify(Board vo) throws Exception;
	public void remove(Integer bno) throws Exception;
	public List<Board> listAll() throws Exception;
	public List<Board> listPage(int page) throws Exception;
	
	public List<Board> listCriteria(Criteria cri) throws Exception;
	
	public int listCountCriteria(Criteria cri) throws Exception;

}
