package com.mycompany.myapp.dto;

import java.util.*;

import org.springframework.format.annotation.*;

public class Member {
	
	private String memberId;
	private String memberName;
	private String memberPw;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date memberBirthday;
	
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public String getMemberPw() {
		return memberPw;
	}
	public void setMemberPw(String memberPw) {
		this.memberPw = memberPw;
	}
	public Date getMemberBirthday() {
		return memberBirthday;
	}
	public void setMemberBirthday(Date memberBirthday) {
		this.memberBirthday = memberBirthday;
	}
}
