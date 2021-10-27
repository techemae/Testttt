package com.wkkmenu.test.controller;


import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wkkmenu.test.service.ITTT000Service;



@Controller
@RequestMapping("/hs")
public class TTT000Controller {
	
	@Autowired
    ITTT000Service service;

	@ResponseBody
	@RequestMapping(value="/hello")
	String hello(String type) {
		System.out.println("hello : " + type);
		return "hello world";
	}
	
	
	@ResponseBody
	@RequestMapping(value="/test")
	String test() throws Exception {
		boolean result = service.get1();
		if (result == true) {
			return "성공";
		}
		else {
			return "실패";
		}
	}
//	public Object get1(HttpServletRequest servletRequest, HttpServletResponse servletResponse,
//			@RequestBody TTT000get1 param) throws UnsupportedEncodingException, Exception {
//		
//	
//			return this.service.getGridDetail(param);
//    	}
	
}
