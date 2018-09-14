package ua.strychak.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ua.strychak.entity.Book;
@Repository
public interface BookRepository  extends JpaRepository<Book, Long>{
	
//	Book findByBookId(Long id);

//	boolean existsByBookId(Long id);
	
	List<Book> findByCategoryId(Long id);


}
