package com.ys.sbbs.utility;

import java.util.List;

public class UtilTest {

	public static void main(String[] args) {
		AsideUtil au = new AsideUtil();
		String roadAddr = au.getRoadAddr("경기도 수원시 장안구청");

		List<String> list = au.getGeoCode(roadAddr);
		String lon = list.get(0);
		String lat = list.get(1);
		System.out.println("경도: " + lon + ", 위도: " + lat);
		
//		String lon = "127.010400656538", lat = "37.3040947298509";
		String weatherStr = au.getWeather(lon, lat);
		System.out.println(weatherStr);
	}

}
