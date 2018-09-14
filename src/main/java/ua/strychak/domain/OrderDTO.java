package ua.strychak.domain;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;
import ua.strychak.entity.Book;
import ua.strychak.entity.User;

@Data
@NoArgsConstructor
public class OrderDTO {

	private Long id;

//	private int orderAmount;

	private BigDecimal price;

	private LocalDate orderDate;

	private User user;

	private List<Book> book;

}
