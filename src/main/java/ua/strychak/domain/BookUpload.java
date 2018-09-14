package ua.strychak.domain;

import java.math.BigDecimal;

import org.springframework.web.multipart.MultipartFile;

public class BookUpload {

	private String title;
	private BigDecimal price;
	private MultipartFile file;

	public BookUpload() {
		super();
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}

}
