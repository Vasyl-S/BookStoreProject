package ua.strychak.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Entity
@Table(name = "publisher")
public class Publisher extends BaseEntity {
	
	
	private String name;
	
	
	@OneToMany(mappedBy = "publisher")
	private List<Book> book;

}
