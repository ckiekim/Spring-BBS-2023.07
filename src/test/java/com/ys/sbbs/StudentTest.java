package com.ys.sbbs;

import java.time.LocalDate;

import com.ys.sbbs.entity.Student;

public class StudentTest {

	public static void main(String[] args) {
		Student st = new Student();
		st.setSid(101);
		st.setName("james");
		st.setRegDate(LocalDate.parse("2023-07-25"));
		System.out.println(st);
		
		st = new Student(102, "maria", LocalDate.parse("2023-07-26"));
		System.out.println(st);
	}

}
