package com.mycompany.myapp.dto;

import org.springframework.validation.*;

public class memberValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Member.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors err) {
		Member member = (Member) target;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(err, "memberId", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(err, "memberPw", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(err, "memberName", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(err, "memberBirthday", "required");
		
		int pwLength = member.getMemberPw().length();
		if(pwLength < 4) {
			err.rejectValue("memberPw", "minLength", new Object[] {4,pwLength}, "4글자 이상 입력");
		}
	}

}
