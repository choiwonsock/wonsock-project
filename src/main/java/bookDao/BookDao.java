package bookDao;

import java.util.Collection;

import bookDto.BookDto;
import model.SearchCommand;

public interface BookDao {

	public Collection<BookDto> listAll();
	public void insert(BookDto books);
	public BookDto selectByNum(Long num);
	public Collection<BookDto> selectByKeyword(SearchCommand SearchCommand);
}
