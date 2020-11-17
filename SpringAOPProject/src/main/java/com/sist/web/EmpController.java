package com.sist.web;
/*
 *  1. 프로젝트 생성
 *     프로젝트명 => 패키지 설정(3개이상)
 *  2. 자바 버전 변경
 *  2-2. pom.xml(라이브러리 추가)
 *     ========
 *     라이브러리가 없는 경우 : mvnrepository.com 검색후 추가
 *  3. web.xml 변경
 *  4. application-context.xml 설정
 *     자바로 설정
 *  5. 자바( Model, DAO,VO) => html
 */

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.sist.dao.*;


@Controller
public class EmpController {
	
	@Autowired
	private EmpDAO dao;
	@GetMapping("emp/list.do")
	public String emp_list(Model model)
	{
		List<EmpVO> list = dao.empListData();
		model.addAttribute("list",list);
		return "emp/list";
	}
	
	@GetMapping("emp/detail.do")
	public String emp_detail(int empno,Model model)
	{
		EmpVO vo =dao.empDetailData(empno);
		model.addAttribute("vo",vo);
		return "emp/detail";
	}
}
