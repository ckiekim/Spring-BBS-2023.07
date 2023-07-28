package com.ys.sbbs.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ys.sbbs.utility.AsideUtil;

@Controller
@RequestMapping("/aside")
public class AsideController {
	@Autowired private AsideUtil asideUtil;

	@ResponseBody				// for ajax
	@GetMapping("/stateMsg")
	public String changeStateMsg(String stateMsg, HttpSession session) {
		session.setAttribute("stateMsg", stateMsg);
		return "0";
	}
	
	@ResponseBody				// for ajax
	@GetMapping("/weather")
	public String getWeather(String addr, HttpSession session) {
		String place = addr + "청";
		String roadAddr = asideUtil.getRoadAddr(place);
		List<String> geoCode = asideUtil.getGeoCode(roadAddr);
		String result = asideUtil.getWeather(geoCode);
		
		return result;
	}
}
