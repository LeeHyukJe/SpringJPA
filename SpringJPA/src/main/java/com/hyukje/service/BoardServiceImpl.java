package com.hyukje.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hyukje.domain.Board;
import com.hyukje.domain.Criteria;
import com.hyukje.persistence.BoardDAO;

@Service
public class BoardServiceImpl implements BoardService{
	
	@Autowired
	private BoardDAO boardDAO;

	@Override
	public void regist(Board vo) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Board read(Long bno) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void modify(Board vo) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remove(Integer bno) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Board> listAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Board> listPage(int page) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Board> listCriteria(Criteria cri) throws Exception {
		// TODO Auto-generated method stub
		return boardDAO.listCriteria(cri);
	}

	@Override
	public int listCountCriteria(Criteria cri) throws Exception {
		// TODO Auto-generated method stub
		return boardDAO.countPaging(cri);
	}

}
