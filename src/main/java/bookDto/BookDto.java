package bookDto;

import org.springframework.web.multipart.MultipartFile;

public class BookDto {
	private Long num;
	private Long isbn;
	private String bookname;
	private String writer;
	private String publish;
	private Long price;
	private String intro;
	private MultipartFile imgFilename;
	private String saveFilename;
	
	public Long getNum() {
		return num;
	}
	public void setNum(Long num) {
		this.num = num;
	}
	public Long getIsbn() {
		return isbn;
	}
	public void setIsbn(Long isbn) {
		this.isbn = isbn;
	}
	public String getBookname() {
		return bookname;
	}
	public void setBookname(String bookname) {
		this.bookname = bookname;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getPublish() {
		return publish;
	}
	public void setPublish(String publish) {
		this.publish = publish;
	}
	public Long getPrice() {
		return price;
	}
	public void setPrice(Long price) {
		this.price = price;
	}
	public String getIntro() {
		return intro;
	}
	public void setIntro(String intro) {
		this.intro = intro;
	}
	public MultipartFile getImgFilename() {
		return imgFilename;
	}
	public void setImgFilename(MultipartFile imgFilename) {
		this.imgFilename = imgFilename;
	}
	public String getSaveFilename() {
		return saveFilename;
	}
	public void setSaveFilename(String saveFilename) {
		this.saveFilename = saveFilename;
	}
	
}
