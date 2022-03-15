package controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import bookDao.BookDaoImpl;
import bookDto.BookDto;
import model.SearchCommand;

@Controller
public class SearchController {
private BookDaoImpl bookDaoImpl;  

	
	public void setBookDaoImpl(BookDaoImpl booksDaoImpl) {
		this.bookDaoImpl = booksDaoImpl;
	}
	
	@RequestMapping(value="/search", method=RequestMethod.GET)
	public String listAll(SearchCommand SearchCommand, Model model) {
		
		List<BookDto> booksList = (List)bookDaoImpl.selectByKeyword(SearchCommand);
		
		model.addAttribute("booksList", booksList);
		
		return "list";
	}
}
