package ua.strychak.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

@Entity
@Table(name = "book")
public class Book extends BaseEntity {

	// @Column(nullable = false, unique = true)
	// private String bookId;

	@Column(length = 120, nullable = false)
	private String title;

	private String description;

	private String imageUrl;

	@Column(columnDefinition = "DECIMAL(6,2) DEFAULT '0.00'")
	private BigDecimal price;

	private LocalDate publicationYear;


//	@ManyToMany(mappedBy = "book")
//	private List<Category> category = new ArrayList<>();

	@ManyToOne
	@JoinColumn(name = "category_id")
	private Category category;

	@ManyToOne
	@JoinColumn(name = "publisher_id")
	private Publisher publisher;
	
	
	@ManyToMany(mappedBy = "book")
	private List<Author> author = new ArrayList<>();
	
	
	@OneToMany(mappedBy = "book")
	private List<Order> order= new ArrayList<>();
	
	
	

}
