package ua.strychak.service;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

import ua.strychak.domain.BookDTO;
import ua.strychak.domain.filter.Simple_Filter;


public interface BookService {
	
	void saveBook(BookDTO book);

	BookDTO findById(Long id);

	List<BookDTO> findAllBooks();

	void deleteBook(Long id);

	List<BookDTO> findBookByCategoryId(Long id);

	List<BookDTO> findAllBooksByPages(Pageable pageable);

	List<BookDTO> findAllBooksBySpecification(Simple_Filter filter);

	void saveFile(MultipartFile file);
	
	String getFile(String fileName);

}
