package com.ys.sbbs.service;

import java.util.List;

import com.ys.sbbs.entity.Anniversary;

public interface AnniversaryService {

	List<Anniversary> getDayAnnivList(String sdate);

	List<Anniversary> getAnnivDays(String start, String end);
	
	void insert(Anniversary anniversary);
	
}
