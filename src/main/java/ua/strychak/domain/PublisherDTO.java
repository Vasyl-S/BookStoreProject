package ua.strychak.domain;

import java.util.List;


import lombok.Data;
import lombok.NoArgsConstructor;
import ua.strychak.entity.Book;

@Data
@NoArgsConstructor
public class PublisherDTO {
	
	private Long id;

	private String name;

	private List<Book> book;

}
