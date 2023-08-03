package com.ys.sbbs.utility;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.ys.sbbs.entity.Anniversary;

public class Anniv {

	public static void main(String[] args) {
		SchedUtil su = new SchedUtil();
		for (int year = 2020; year <= 2025; year++) {
			List<Anniversary> list = su.getAnnivList("공휴일", year);
			List<Anniversary> list2 = su.getAnnivList("24절기", year);
			System.out.printf("%d: 공휴일:%d, 24절기:%d%n", year, list.size(), list2.size());
		}
	}

}
