package ua.strychak.service.impl;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import ua.strychak.domain.BookDTO;
import ua.strychak.domain.filter.Simple_Filter;
import ua.strychak.entity.Book;
import ua.strychak.repository.BookRepository;
import ua.strychak.service.BookService;
import ua.strychak.service.utils.CustomFileUtils;
import ua.strychak.service.utils.ObjectMapperUtils;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookRepository bookRepository;

	@Autowired
	private ObjectMapperUtils objectMapper;
	
	@Autowired
	private CustomFileUtils fileUtils;

	@Override
	public void saveBook(BookDTO bookDTO) {
		Book book = objectMapper.map(bookDTO, Book.class);
		bookRepository.save(book);
	}

	@Override
	public BookDTO findById(Long id) {
		Book book = bookRepository.findById(id).get();
		BookDTO dto = objectMapper.map(book, BookDTO.class);
		return dto;
	}

	@Override
	public List<BookDTO> findAllBooks() {
		List<Book> books = bookRepository.findAll();
		List<BookDTO> bookDTOs = objectMapper.mapAll(books, BookDTO.class);
		return bookDTOs;
	}

	@Override
	public void deleteBook(Long id) {
		bookRepository.deleteById(id);

	}

	@Override
	public List<BookDTO> findBookByCategoryId(Long id) {
		List<Book> book = bookRepository.findByCategoryId(id);
		List<BookDTO> bookDTOs = objectMapper.mapAll(book, BookDTO.class);
		return bookDTOs;
	}

	@Override
	public List<BookDTO> findAllBooksByPages(Pageable pageable) {
		Page<Book> booksPage = bookRepository
				.findAll(PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(), pageable.getSort()));
		List<Book> books = booksPage.getContent();
		List<BookDTO> bookDTOs = objectMapper.mapAll(books, BookDTO.class);

		return bookDTOs;
	}

	@Override
	public void saveFile(MultipartFile file) {
		try {
			fileUtils.saveUploadedFile(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public String getFile(String fileName) {
		return fileUtils.getFile(fileName);
	}

	@Override
	public List<BookDTO> findAllBooksBySpecification(Simple_Filter filter) {
		return objectMapper.mapAll(bookRepository.findAll((Sort) getSpecification(filter)), BookDTO.class);
	}

	private Specification<Book> getSpecification(Simple_Filter filter) {

		return new Specification<Book>() {

			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public Predicate toPredicate(Root<Book> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {

				if (filter.getSearch().isEmpty()) {
					return null;
				}

				Expression<String> searchByTitleExp = root.get("title");
				Predicate searchByTitlePredicate = criteriaBuilder.like(searchByTitleExp,
						"%" + filter.getSearch() + "%");

				Expression<String> searchByIsbnExp = root.get("isbn");
				Predicate searchByIsbnPredicate = criteriaBuilder.equal(searchByIsbnExp, filter.getSearch());

				Expression<BigDecimal> priceFromExp = root.get("price");
				Predicate priceFromPredicate = criteriaBuilder.greaterThanOrEqualTo(priceFromExp,
						new BigDecimal("1000"));

				return criteriaBuilder.or(searchByTitlePredicate, searchByIsbnPredicate, priceFromPredicate);
				// SELECT b FROM Book b WHERE title LIKE '%erer%'
			}

		};
	}

}
