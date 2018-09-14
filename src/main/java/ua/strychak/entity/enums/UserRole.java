package ua.strychak.entity.enums;

import org.springframework.security.core.GrantedAuthority;

public enum UserRole  implements GrantedAuthority{

	ROLE_ADMIN, ROLE_USER , ROLE_PROVIDER;

	@Override
	public String getAuthority() {
		return name();
	}

	
}
