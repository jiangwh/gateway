package com.jiangwh.service;

import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public final class HelloService {

	@Transactional
	public void hello(){
		//do nothing
	}
}
