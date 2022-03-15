package controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import bookDao.BookDaoImpl;
import bookDto.BookDto;

@Controller
public class ListController {

	private BookDaoImpl booksDaoImpl;  
	
	public void setBookDaoImpl(BookDaoImpl booksDaoImpl) {
		this.booksDaoImpl = booksDaoImpl;
	}
	
	@RequestMapping("/list")
	public String listAll(Model model) {

		List<BookDto> booksList = (List)booksDaoImpl.listAll();
		
		model.addAttribute("booksList", booksList);
		
		return "list";
	}
}
