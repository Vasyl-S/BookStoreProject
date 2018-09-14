package ua.strychak.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

@Entity
@Table(name = "author", indexes = @Index(columnList = "lastName, email"))
public class Author extends BaseEntity{

//	@Column(nullable = false, unique = true)
//	private String authorId;
	
	@Column(nullable = false)
	private String firstName;
	
	@Column(nullable = false)
	private String lastName;
	
	@Column(unique = true, nullable = false)
	private String email;
	
	private String imageUrl;
	
	private LocalDate dateOfBirth; // format is 2007-12-03
	
	
	@ManyToMany
	@JoinTable(name = "author_book", joinColumns = @JoinColumn(name = "author_id"), inverseJoinColumns = @JoinColumn(name = "book_id"))
	private List<Book> book = new ArrayList<>();
	
	
	
	
//	
//	@OneToMany(mappedBy = "author")
//	private List<BookAuthor> bookAuthor;
//	@ManyToMany
//	@JoinTable(name = "authors_books", joinColumns = @JoinColumn(name = "author_id"), inverseJoinColumns = @JoinColumn(name = "book_id"))
//	private List<Book> book = new ArrayList<>();
//	
//	
	
	
	
	
	
}
