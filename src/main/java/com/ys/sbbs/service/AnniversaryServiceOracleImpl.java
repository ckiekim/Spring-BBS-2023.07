package com.ys.sbbs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ys.sbbs.dao.AnniversaryDaoOracle;
import com.ys.sbbs.entity.Anniversary;

@Service
public class AnniversaryServiceOracleImpl implements AnniversaryService {
	
	@Autowired private AnniversaryDaoOracle annivDao;

	@Override
	public List<Anniversary> getDayAnnivList(String sdate) {
		List<Anniversary> list = annivDao.getAnnivList(sdate, sdate);
		return list;
	}

	@Override
	public List<Anniversary> getAnnivDays(String start, String end) {
		List<Anniversary> list = annivDao.getAnnivList(start, end);
		return list;
	}

	@Override
	public void insert(Anniversary anniversary) {
		annivDao.insert(anniversary);
	}

}
