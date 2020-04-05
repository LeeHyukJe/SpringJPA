package com.hyukje.persistence;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hyukje.domain.Board;
import com.hyukje.domain.Criteria;

@Repository
public class BoardDAOImpl implements BoardDAO {
	
	private static final String namespace="com.hyukje.persistence.Board";
	
	@Autowired
	private SqlSession session;

	@Override
	public void create(Board vo) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Board read(Long bno) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Board vo) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Integer bno) throws Exception {
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
		if(page<=0) {
			page = 1;
		}
		page = (page-1) *10;
		
		return session.selectList(namespace+".listPage",page);
	}

	@Override
	public List<Board> listCriteria(Criteria cri) throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(namespace+".listCriteria",cri);
	}

	@Override
	public int countPaging(Criteria cri) throws Exception {
		// TODO Auto-generated method stub
		return session.selectOne(namespace+".countPaging",cri);
	}

}
