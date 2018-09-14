package ua.strychak.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import ua.strychak.entity.Author;



public interface AuthorRepository  extends JpaRepository<Author, Long>{

	
//	boolean existsByAuthorId(Long id);

	boolean existsByEmail(String email);

}
