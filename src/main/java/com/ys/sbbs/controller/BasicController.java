package com.ys.sbbs.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/basic")
public class BasicController {

	// localhost:8080/sbbs/basic/basic1
	@RequestMapping("/basic1")
	public String basic1() {
		// application.properties에 prefix=/WEB-INF/view/, suffix=.jsp
		// /WEB-INF/view/ + basic/basic1 + .jsp	==>	/WEB-INF/view/basic/basic1.jsp
		return "basic/basic1";
	}
	
	@ResponseBody
	@RequestMapping("/basic2")
	public String basic2() {
		// 문자열을 출력
		return "<h1>문자열을 웹화면으로 보낼때 @ResponseBody 를 사용</h1>";
	}
	
	@RequestMapping("/basic3")
	public String basic3(Model model) {
		model.addAttribute("filename", "basic3.jsp");
		model.addAttribute("message", "Model 객체를 통해서 데이터가 전달됩니다.");
		List<String> fruits = new ArrayList<>();
		fruits.add("사과"); fruits.add("수박"); fruits.add("참외"); 
		model.addAttribute("fruits", fruits);
		return "basic/basic3";
	}
	
	@ResponseBody
	@RequestMapping("/basic4")
	public String basic4(HttpServletRequest req) {
		String id = req.getParameter("id");
		return "<h1>파라메터로 받은 id 값은 " + id + " 입니다.<br>" + 
				"기존 방식의 HttpServletRequest 로 받을 수 있습니다.</h1>";
	}
	
	// localhost:8080/sbbs/basic/basic5?num=3&id=spring
	@ResponseBody
	@RequestMapping("/basic5")
	public String basic5(int num, @RequestParam(name="id", defaultValue="spring") String id) {
		return "<h1>파라메터로 받은 num 값은 " + num + " 입니다.<br>" + 
				"파라메터로 받은 id 값은 " + id + " 입니다.</h1>";
	}
	
	// localhost:8080/sbbs/basic/basic5/3/spring 
	// Servlet에서는 불가능한 방법
	@RequestMapping("/basic6/{num}/{id}")
	public String basic6(@PathVariable int num, @PathVariable String id) {
		return "redirect:/sbbs/basic/basic5?num=" + num + "&id=" + id;
	}
	
	@GetMapping("/basic7")
	public String basic7(HttpServletRequest req, Model model) {
		HttpSession session = req.getSession();
		session.setAttribute("sessionMsg", "세션을 통한 메세지 전달");
		model.addAttribute("modelMsg", "모델을 통한 메세지 전달");
		return "basic/basic7";
	}
	
	@GetMapping("/basic8")
	public String basic8get() {
		return "basic/basic8";
	}
	
	@ResponseBody
	@PostMapping("/basic8")
	public String basic8post(String id, String pwd) {
		return "<h1>id: " + id + ", pwd: " + pwd + "</h1>";
	}
	
}
