package ua.strychak.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

@Entity
@Table(name = "category", indexes = @Index(columnList = "name"))
public class Category extends BaseEntity {
	
	private String name;
	
	
	@OneToMany(mappedBy = "category")
	private List<Book> book;
//
//	@ManyToMany
//	@JoinTable(name = "books_categories", joinColumns = @JoinColumn(name = "category_id"), inverseJoinColumns = @JoinColumn(name = "book_id"))
//	private List<Book> books = new ArrayList<>();
	

}
