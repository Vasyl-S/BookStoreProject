package ua.strychak.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ua.strychak.entity.enums.UserRole;

@Getter
@Setter
@NoArgsConstructor

@Entity
@Table(name = "user")
public class User extends BaseEntity {
		
	@Column(nullable = false, unique = true)
	private String username;

	@Column(nullable = false)
	private String password;
	
	@Column(nullable = false, unique = true)
	private String email;

	private String firstName;

	private String lastName;

	@Enumerated(EnumType.ORDINAL)
	private UserRole role;
		
	private String emailVerificationToken;


		@Column(nullable = true , columnDefinition = "boolean default false")
		private Boolean emailVerificationStatus;
		
		@OneToMany(mappedBy = "user")
		private List<Order> order= new ArrayList<>();
		

}
