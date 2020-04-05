package com.hyukje.persistence;

import java.util.List;

import com.hyukje.domain.Board;
import com.hyukje.domain.Criteria;

public interface BoardDAO {
	public void create(Board vo) throws Exception;
	public Board read(Long bno) throws Exception;
	public void update(Board vo) throws Exception;
	public void delete(Integer bno) throws Exception;
	public List<Board> listAll() throws Exception;
	public List<Board> listPage(int page) throws Exception;
	
	public List<Board> listCriteria(Criteria cri) throws Exception;
	public int countPaging(Criteria cri) throws Exception;
	
}
