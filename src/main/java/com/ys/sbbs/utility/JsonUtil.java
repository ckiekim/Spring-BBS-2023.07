package com.ys.sbbs.utility;

import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class JsonUtil {

	public String listToJson(List<String> list) {
		JSONObject jObj = new JSONObject();
		jObj.put("list", list);
		return jObj.toString();
	}
	
	public List<String> jsonToList(String jStr) {
		JSONParser parser = new JSONParser();
		List<String> list = null;
		try {
			JSONObject jObj = (JSONObject) parser.parse(jStr);
			JSONArray jArr = (JSONArray) jObj.get("list");
			list = (List<String>) jArr;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
}
