package com.kedu.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kedu.dao.CafeDAO;
import com.kedu.dto.CafeDTO;


@Controller
public class HomeController {
	
	@Autowired
	private CafeDAO dao;
	

	@RequestMapping(value = "/")
	public String home() {
		System.out.println("Home요청 확인");
		return "home";
	}
	
	@RequestMapping(value = "/input")
	public String input() {
		System.out.println("input요청 확인");
		return "input";
	}
	
	@RequestMapping(value = "/inputMenu")
	public String inputMenu(CafeDTO dto) {
		System.out.println("inputMenu 요청 확인");
		System.out.println(dto.getName()+dto.getPrice());
		try {
			dao.insert(dto);
			return "home";
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return "input";
	}
	
}
