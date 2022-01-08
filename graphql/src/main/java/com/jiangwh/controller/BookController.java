package com.jiangwh.controller;

import com.jiangwh.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {

	@Autowired
	HelloService service;

	@GetMapping(path = "/hello")
	public String hello() {
		service.hello();
		return "Hello";
	}
}
