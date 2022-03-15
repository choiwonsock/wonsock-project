package model;

import java.io.File;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

import bookDao.BookDaoImpl;
import bookDto.BookDto;

public class RegisterService {

	private BookDaoImpl bookDaoImpl;
	
	public RegisterService() {}
	
	public RegisterService(BookDaoImpl bookDaoImpl) {
		System.out.println("RegisterService(BookDaoImpl)");
		this.bookDaoImpl = bookDaoImpl;
	}
	
	public void booksRegist(BookDto books, HttpServletRequest request) {
		BookDto newBook = new BookDto();
		try {
		MultipartFile fileName = books.getImgFilename();
		String oriFileName = fileName.getOriginalFilename();
		String storedFileName = UUID.randomUUID().toString().replaceAll("-", "");
		
		String folderPath = "/resources/upload/";
		String realPath = request.getServletContext().getRealPath(folderPath);
		
		File file = new File(realPath, oriFileName);

		fileName.transferTo(file);
			
		newBook.setBookname(books.getBookname());
		newBook.setWriter(books.getWriter());
		newBook.setPrice(books.getPrice());
		newBook.setIntro(books.getIntro());
		newBook.setSaveFilename(oriFileName);
		newBook.setIsbn(books.getIsbn());
		newBook.setPublish(books.getPublish());
		
		bookDaoImpl.insert(newBook);
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
}
