package com.kedu.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kedu.dao.MessagesDAO;
import com.kedu.dto.MessagesDTO;

@Controller
public class HomeController {

	@Autowired
	private MessagesDAO dao;

	@RequestMapping("/")
	public String home() {
		System.out.println("Home 요청 확인");
		return "search"; // home.jsp
	}
	
	@RequestMapping("/search")
	public String search(String column, String keyword) throws Exception {
		dao.selectByCon(column,keyword);
		return "search";	
	}
	
	@RequestMapping("/searchMulti")
	public String searchMulti(String writer, String message) throws Exception {
		dao.selectByMultiCon(writer,message);
		return "search";
		
	}

	@RequestMapping("/input")
	public String input() {
		System.out.println("Input 요청 확인");
		return "input"; // 포워드
	}

	@RequestMapping("/inputProc")
	public String inputProc(MessagesDTO dto) throws Exception { // 필요할 때 request를 매개변수로 받아라. response과 세션 마찬가지
		System.out.println(dao);
		dao.insert(dto);
		return "redirect: /";
	}

	@RequestMapping("/output")
	public String output(Model model) throws Exception { // jsp에 정보보낼때 model사용
		List<Map<String,Object>> list = dao.selectAll();
		model.addAttribute("list", list);
		return "output";
	}

	@RequestMapping("/delete")
	public String delete(String seq) throws Exception {
		dao.delete(Integer.parseInt(seq));
		return "redirect: /";
	}

	
	  @RequestMapping("/update") 
	  public String update(String writer) throws Exception {
		  //System.out.println(writer);
		  //System.out.println(dto.getWriter()); 
		  //dao.update(dto); 
		  return "redirect: /output"; 
	  }
	 

	// try-catch축약
	@ExceptionHandler(Exception.class)
	public String exceptionHandler(Exception e) {
		e.printStackTrace();
		return "error";
	}

}
