package com.sist.web;
	
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;

import javax.servlet.http.HttpServletRequest;
	
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
// 1. 값 받는 방법 
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class MainController {
	//ID,PassWord
	//1. 입력하는 JSP
	@RequestMapping("main/input.do")
	//매개변수는 DispatcherServlet이 설정해준다. (순서도 상관없다)
	public String main_input(HttpServletRequest request) //디스패쳐 서블릿은 만들어논 상태이므로 response를 요청하면 바로 값이들어온다 
	{
		
		String id= request.getParameter("id");
		String pwd=request.getParameter("pwd");
		
		request.setAttribute("id",id);
		request.setAttribute("pwd",pwd);
		return "main/output";
	}
	
	@RequestMapping("main/input.do")
	public String main_input()
	{
		return "main/input";
	}
	
	@RequestMapping("main/output2.do")
	public String main_output2(String id,String pwd,Model model) //디스 패쳐 서블릿이 값을 넣어준다.
	{	  
		// Model => 인터페이스 (해당 JSP로 데이터 전송 역할)
		// 전송
		model.addAttribute("id",id);
		model.addAttribute("pwd",pwd);
		// Spring => 요청값 받는 경우 => 매개변수로 받는다, 전송시에는 Model을 이용해서 전송
		/*
		 * 	public class Model
		 * 	{
		 * 		HttpServletRequest request;
		 * 		public void addAttribute(String key,Object obj)
		 * 		{
		 * 			request.setAttribute(key,obj) -> DispatcherServlet
		 * 		}
		 * 	
		 * 	}
		 */
		return "main/output2";
	}
	
}	
