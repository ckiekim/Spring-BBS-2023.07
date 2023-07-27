package com.ys.sbbs.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ys.sbbs.entity.Board;
import com.ys.sbbs.service.BoardService;

@Controller
@RequestMapping("/board")
public class BoardController {
	@Autowired private BoardService boardService;
	
	@GetMapping("/list")
	public String list(@RequestParam(name="p", defaultValue="1") int page,
					   @RequestParam(name="f", defaultValue="title") String field,
					   @RequestParam(name="q", defaultValue="") String query,
					   HttpSession session, Model model) {
		List<Board> list = boardService.listBoard(field, query, page);
		
		int totalBoardCount = boardService.getBoardCount(field, query);
		int totalPages = (int) Math.ceil(totalBoardCount / (double) BoardService.LIST_PER_PAGE);
		int startPage = (int) Math.ceil((page-0.5)/BoardService.PAGE_PER_SCREEN - 1) * BoardService.PAGE_PER_SCREEN + 1;
		int endPage = Math.min(totalPages, startPage + BoardService.PAGE_PER_SCREEN - 1);
		List<String> pageList = new ArrayList<String>();
		for (int i = startPage; i <= endPage; i++)
			pageList.add(String.valueOf(i));
		
		session.setAttribute("currentBoardPage", page);
		model.addAttribute("boardList", list);
		model.addAttribute("field", field);
		model.addAttribute("query", query);
		model.addAttribute("today", LocalDate.now().toString());
		model.addAttribute("totalPages", totalPages);
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);
		model.addAttribute("pageList", pageList);
		return "board/list";
	}

}
