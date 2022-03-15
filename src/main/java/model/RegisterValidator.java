package model;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import bookDto.BookDto;

public class RegisterValidator implements Validator{
	@Override
	public boolean supports(Class<?> arg0) {
		return BookDto.class.isAssignableFrom(arg0);
	}
	
	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmpty(errors, "bookname", "required","필수 항목 입니다");
		ValidationUtils.rejectIfEmpty(errors, "writer", "required","필수 항목 입니다");
		ValidationUtils.rejectIfEmpty(errors, "publish", "required","필수 항목 입니다");
		ValidationUtils.rejectIfEmpty(errors, "intro", "required","필수 항목 입니다");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "price", "required","필수 항목 입니다");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "isbn", "required","필수 항목 입니다");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "imgFilename", "required","필수 항목 입니다");
		
		BookDto books = (BookDto)target;
	}
}
