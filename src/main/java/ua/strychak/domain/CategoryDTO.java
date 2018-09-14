package ua.strychak.domain;
import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class CategoryDTO {

	private Long id;
	private String name;
	private List<BookDTO> books;

}
