package ua.strychak.domain;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BookDTO {
	
	private Long id;
	private String title;
	private String description;
	private String imageUrl;
	private BigDecimal price;
	private LocalDate publicationYear;
	private List<AuthorDTO> authors;
	private CategoryDTO category;
	private PublisherDTO publisher;
	private List<OrderDTO> order;

}
