package ua.strychak.domain;

import java.util.List;


import lombok.Data;
import lombok.NoArgsConstructor;
import ua.strychak.entity.Order;
import ua.strychak.entity.enums.UserRole;

@Data
@NoArgsConstructor
public class UserDTO {

	private Long id;

	private String username;

	private String password;

	private String email;

	private String firstName;

	private String lastName;

	private List<Order> order;
	
	private UserRole role;


}
