package com.ys.sbbs.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.ys.sbbs.entity.User;
import com.ys.sbbs.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired private UserService userService;
	
	@GetMapping("/register")
	public String registerForm() {
		return "user/register";
	}
	
	@PostMapping("/register")
	public String registerProc(MultipartHttpServletRequest req, Model model) {
		String uid = req.getParameter("uid");
		String pwd = req.getParameter("pwd");
		String pwd2 = req.getParameter("pwd2");
		String uname = req.getParameter("uname");
		String email = req.getParameter("email");
		
		String addr = req.getParameter("addr");
		
		if (userService.getUser(uid) != null) {
			model.addAttribute("msg", "사용자 ID가 중복되었습니다.");
			model.addAttribute("url", "/sbbs/user/register");
			return "common/alertMsg";
		}
		if (pwd.equals(pwd2) && pwd.length()>=1) {
			String hashedPwd = BCrypt.hashpw(pwd, BCrypt.gensalt());
			User user = new User(uid, hashedPwd, uname, email, null, addr);
			userService.insertUser(user);
			model.addAttribute("msg", "등록을 마쳤습니다. 로그인하세요.");
			model.addAttribute("url", "/sbbs/user/login");
			return "common/alertMsg";
		} else {
			model.addAttribute("msg", "패스워드 입력이 잘못되었습니다.");
			model.addAttribute("url", "/sbbs/user/register");
			return "common/alertMsg";
		}
	}
	
	@GetMapping("/login")
	public String loginForm() {
		return "user/login";
	}
	
	@PostMapping("/login")
	public String loginProc(String uid, String pwd, HttpSession session, Model model) {
		int result = userService.login(uid, pwd);
		if (result == UserService.CORRECT_LOGIN) {
			session.setAttribute("uid", uid);
			User user = userService.getUser(uid);
			session.setAttribute("uname", user.getUname());
			session.setAttribute("email", user.getEmail());
			session.setAttribute("addr", user.getAddr());
			session.setAttribute("profile", user.getProfile());
			
			// 상태 메세지
			// D:\JavaWorkspace\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\bbs\WEB-INF/data/todayQuote.txt
//			String quoteFile = getServletContext().getRealPath("/") + "WEB-INF/data/todayQuote.txt";
//			AsideUtil au = new AsideUtil();
//			String stateMsg = au.getTodayQuote(quoteFile);
//			session.setAttribute("stateMsg", stateMsg);
			
			// 환영 메세지
			model.addAttribute("msg", user.getUname() + "님 환영합니다.");
//			model.addAttribute("url", "/sbbs/board/list?p=1&f=&q=");
			model.addAttribute("url", "/sbbs/user/list/1");
			return "common/alertMsg";
		} else if (result == UserService.WRONG_PASSWORD) {
			model.addAttribute("msg", "잘못된 패스워드입니다. 다시 입력하세요.");
			model.addAttribute("url", "/sbbs/user/login");
			return "common/alertMsg";
		} else {		// UID_NOT_EXIST
			model.addAttribute("msg", "ID가 없습니다. 회원가입 페이지로 이동합니다.");
			model.addAttribute("url", "/sbbs/user/register");
			return "common/alertMsg";
		}
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirec:/sbbs/user/login";
	}
	
	@GetMapping("/list/{page}")
	public String list(@PathVariable int page, HttpSession session, Model model) {
		List<User> list = userService.getUserList(page);
		model.addAttribute("userList", list);
		int totalUsers = userService.getUserCount();
		int totalPages = (int) Math.ceil(totalUsers / 10.);
		session.setAttribute("currentUserPage", page);
		List<String> pageList = new ArrayList<>();
		for (int i = 1; i <= totalPages; i++)
			pageList.add(String.valueOf(i));
		model.addAttribute("pageList", pageList);
		
		return "user/list";
	}
	
	@GetMapping("/update/{uid}") 
	public String update(@PathVariable String uid, Model model) {
		User user = userService.getUser(uid);
		model.addAttribute("user", user);
		return "user/update";
	}
}
