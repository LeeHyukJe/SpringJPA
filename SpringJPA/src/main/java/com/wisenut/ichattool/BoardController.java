package com.wisenut.ichattool;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hyukje.domain.Criteria;
import com.hyukje.domain.PageMaker;
import com.hyukje.service.BoardService;

import lombok.extern.java.Log;

@Log
@Controller
@RequestMapping(value="/board")
public class BoardController {
	
	private BoardService boardService;
	
	@Autowired
	public BoardController(BoardService boardService) {
		this.boardService = boardService;
	}
	
	@RequestMapping(value="/listCri", method=RequestMethod.GET)
	public String listAll(Criteria cri, Model model) throws Exception{
		
		PageMaker maker = new PageMaker();
		maker.setCri(cri);
		maker.setTotalCount(131);
		
		model.addAttribute("list", boardService.listCriteria(cri));
		return "board/listCri";
	}
	
	@RequestMapping(value="/listPage", method=RequestMethod.GET)
	public String listPage(Criteria cri, Model model) throws Exception{
		
		model.addAttribute("list", boardService.listCriteria(cri));
		
		PageMaker maker = new PageMaker();
		maker.setCri(cri);
//		maker.setTotalCount(131);
		maker.setTotalCount(boardService.listCountCriteria(cri));
		
		
		model.addAttribute("pageMaker", maker);
		return "board/listPage";
	}
	

}
