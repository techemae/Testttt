package com.wkkmenu.test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wkkmenu.test.mapper.ITTT000Mapper;


@Service
public class ITTT000Service {

	@Autowired
	private ITTT000Mapper mapper;
	
	public boolean get1() throws Exception {
		return mapper.get1();
	}
}
