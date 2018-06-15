package com.yash.springpemapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {

	@RequestMapping("test/hello")
	public String showHelloPage() {
		return "hello";
	}
}
