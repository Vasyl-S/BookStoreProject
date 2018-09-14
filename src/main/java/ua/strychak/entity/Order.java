package ua.strychak.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

@Entity
@Table(name = "orders")
public class Order extends BaseEntity {
	
	private int orderAmount;
	
	@Column(columnDefinition = "DECIMAL(6,2) DEFAULT '0.00'")
	private BigDecimal price;
	
	private LocalDate orderDate;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	
	@ManyToOne
	@JoinColumn	(name = "book_id")
	private Book book;
	
	
	
}
