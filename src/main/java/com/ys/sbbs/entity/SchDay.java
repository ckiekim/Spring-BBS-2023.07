package com.ys.sbbs.entity;

import java.time.LocalDate;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
public class SchDay {
	private int day;
	private int date;		// 요일 (0-일요일, ..., 6-토요일)
	private int isHoliday;
	private int isOtherMonth;
	private String sdate;		// 20230802
	private List<String> annivList;
	private List<Schedule> schedList;
}
