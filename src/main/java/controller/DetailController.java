package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import bookDao.BookDaoImpl;
import bookDto.BookDto;

@Controller
public class DetailController {

	private BookDaoImpl booksDaoImpl;
	
	public void setBookDaoImpl(BookDaoImpl booksDaoImpl) {
		this.booksDaoImpl = booksDaoImpl;
	}

	@RequestMapping("/detail/{num}")
	public String detail(@PathVariable("num") Long num, Model model ) {
		BookDto books = booksDaoImpl.selectByNum(num);
		model.addAttribute("books", books);
		return "detail";
	}
}
