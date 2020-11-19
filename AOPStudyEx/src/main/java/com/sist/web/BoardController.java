package com.sist.web;

import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.*;
import com.sist.dao.*;

@Controller
public class BoardController {
	@Autowired
	private BoardDAO dao;
	
	@GetMapping("board/list.do")
	public String board_list(Model model,String page)
	{
		if(page==null)
			page="1";
		int curpage=Integer.parseInt(page);
		Map map = new HashMap();
		int rowSize=15;
		int start=(rowSize*curpage)-(rowSize-1);
		int end=rowSize*curpage;
		
		map.put("start",start);
		map.put("end",end);
		
		List<BoardVO> list = dao.boardList(map);
		
		model.addAttribute("list",list);
		return "board/list";
	}
	@GetMapping("board/insert.do")
	public String board_insert()
	{
		
		return "board/insert";
	}
	
	@PostMapping("board/insert_ok.do")
	public String board_insert_ok(BoardVO vo)
	{
		dao.boardInsert(vo);
		
		return "redirect:list.do";
	}
	
	
	@GetMapping("board/detail.do")
	public String board_detail(int no,Model model)
	{
		//디비 연결
		BoardVO vo=dao.boardDetailData(no);
		//데이터 전송
		model.addAttribute("vo",vo);
		return "board/detail";
	}
	
	@GetMapping("board/reply.do")
	public String board_reply(int no,Model model)
	{
		model.addAttribute("no",no);
		return "board/reply";
	}
	/*
	 *  <a>, location.href="" => GetMapping
	 *  <form> => PostMapping
	 */
	@PostMapping("board/reply_ok.do")
	public String board_reply_ok(int pno,BoardVO vo)
	{
		dao.boardReplyInsert(pno, vo);
		
		return "redirect:../board/list.do";
	}
}
