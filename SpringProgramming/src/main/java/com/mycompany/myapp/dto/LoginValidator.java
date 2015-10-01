package com.mycompany.myapp.dto;

import org.springframework.validation.*;

public class LoginValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Login.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors err) {
		Login login = (Login) target;
		
		/*if(memberId == null || memberId.equals("")) {
			err.rejectValue("memberId", "required", "필수 항목입니다.");
		}*/
		ValidationUtils.rejectIfEmptyOrWhitespace(err, "memberId", "required","필수 항목입니다.");
		ValidationUtils.rejectIfEmptyOrWhitespace(err, "memberPw", "required", "필수 항목입니다.");
		
		int pwLength = login.getMemberPw().length();
		if(pwLength < 4) {
			err.rejectValue("memberPw", "minlength", new Object[] {4, pwLength}, "4글자 이상 입력");
		}
	}

}
