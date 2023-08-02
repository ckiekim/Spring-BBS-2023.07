package com.ys.sbbs.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.ys.sbbs.entity.Anniversary;

@Mapper
public interface AnniversaryDaoOracle {

	@Select("SELECT * FROM anniversary"
			+ "  where adate >= #{start} AND adate <= #{end}"
			+ "  ORDER BY adate")
	List<Anniversary> getAnnivList(String start, String end);
	
	@Insert("insert into anniversary values"
			+ "  (default, #{aname}, #{adate}, #{isHoliday})")
	void insert(Anniversary anniversary);
	
}
