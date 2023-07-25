package com.ys.sbbs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/sbbs/basic")
public class BasicController {

	// localhost:8080/sbbs/basic/basic1
	@RequestMapping("/basic1")
	public String basic1() {
		// application.properties에 prefix=/WEB-INF/view/, suffix=.jsp
		// /WEB-INF/view/basic/basic1.jsp
		return "basic/basic1";
	}
	
}
