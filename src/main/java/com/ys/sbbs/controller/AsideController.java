package com.ys.sbbs.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/aside")
public class AsideController {

	@ResponseBody				// for ajax
	@GetMapping("/stateMsg")
	public String changeStateMsg(String stateMsg, HttpSession session) {
		session.setAttribute("stateMsg", stateMsg);
		return "0";
	}
	
}
