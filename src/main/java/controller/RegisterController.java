package controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import bookDto.BookDto;
import model.RegisterService;
import model.RegisterValidator;

@Controller
@RequestMapping("/add")
public class RegisterController {
	private RegisterService RegisterService;
	private RegisterValidator RegisterValidator;

	@RequestMapping(method=RequestMethod.GET)
	public String regForm(BookDto books) {
		
		return "form";
	}
	
	public void setRegisterService(RegisterService RegisterService) {
		
		this.RegisterService = RegisterService;
	}
	
	public void setRegisterValidator(RegisterValidator RegisterValidator) {
		
		this.RegisterValidator = RegisterValidator;
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String regSuccess(BookDto books, Errors errors, HttpServletRequest request) {
		
		RegisterValidator.validate(books, errors);
		if(errors.hasErrors()) {
		      
	         
	         return "form";
	      }
		
		RegisterService.booksRegist(books,request);
		return "redirect:/list";
	}
}
