package com.ys.sbbs.entity;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString; 

/*
 * 아래의 어노테이션을 사용하게 되면
 * 		기본 생성자, 모든 멤버변수 생성자, toString(), Getter/Setter를 만들어 줌
 */
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
public class Student {
	private int sid;
	private String name;
	private LocalDate regDate;
/*****
	public Student() { }
	public Student(int sid, String name, LocalDate regDate) {
		this.sid = sid;
		this.name = name;
		this.regDate = regDate;
	}
	
	@Override
	public String toString() {
		return "Student [sid=" + sid + ", name=" + name + ", regDate=" + regDate + "]";
	}
	
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public LocalDate getRegDate() {
		return regDate;
	}
	public void setRegDate(LocalDate regDate) {
		this.regDate = regDate;
	}
*****/
}
