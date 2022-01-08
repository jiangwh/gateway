package com.jiangwh;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LogController {

	@GetMapping("/test")
	@AccessLogAnnotation
	public String getTest() {
		return "you got test!";
	}


	@PostMapping("/body")
	@AccessLogAnnotation
	public String getBody() {
		return "you got test!";
	}
}
