package com.hyukje.persistence;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.hyukje.domain.Board;

public interface BoardRepository extends JpaRepository<Board, Long>{

	public Optional<Board> findBybno(Long bno);
	public Collection<Board> findByWriterContaining(String writer);
	public Optional<Board> findByBnoLessThanAndBnoGreaterThan(Long less, long greater);
	public Optional<Board> findByBnoLessThanAndBnoGreaterThanOrderByBnoDesc(long less, long greater);
	public List<Board> findByBnoLessThanAndBnoGreaterThanOrderByBnoDesc(long less, long greater, Pageable paging);
	public Page<Board> findByBnoGreaterThanEqualOrderByBnoDesc(long greater, Pageable paging);
	
	@Query("SELECT b from Board b where b.title like %?1% and b.bno > 0 order by b.bno desc")
	public List<Board> findByTitle(String title);
	@Query("select b.bno, b.title, b.title from Board b where b.title like %?1% and b.bno > 0 order by b.bno desc")
	public List<Object[]> findByTitle2(String title);
	@Query("select b from Board b where b.bno > 0 order by b.bno desc")
	public List<Board> findByPage(Pageable pageable);
}
