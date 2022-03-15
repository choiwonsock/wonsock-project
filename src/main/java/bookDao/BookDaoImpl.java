package bookDao;

import java.util.Collection;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;

import bookDto.BookDto;
import model.SearchCommand;

public class BookDaoImpl implements BookDao {
	private SqlSessionTemplate sqlSessionTemplate;

	public BookDaoImpl(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}
	
	@Override
	public Collection<BookDto> listAll() {
		return sqlSessionTemplate.selectList("list");
	}
	
	@Override
	public void insert(BookDto books) {
		sqlSessionTemplate.insert("insert", books);
	}
	
	@Override
	public BookDto selectByNum(Long num) {
		List<BookDto> results = sqlSessionTemplate.selectList("selectByNum", num);
		return results.isEmpty() ? null : results.get(0);
	}
	
	@Override
	public Collection<BookDto> selectByKeyword(SearchCommand booksSearchCommand) {
		return sqlSessionTemplate.selectList("selectByKeyword", booksSearchCommand);
	}

}
