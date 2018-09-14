package ua.strychak.domain;
import java.time.LocalDate;
import java.util.List;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AuthorDTO {
	
	private Long id;	
	private String firstName;	
	private String lastName;	
	private String email;
	private String imageUrl;
	private LocalDate dateOfBirth; // format is 2007-12-03
	private List<BookDTO> books;

}
