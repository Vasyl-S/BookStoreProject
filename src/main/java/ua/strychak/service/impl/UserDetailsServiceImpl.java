package ua.strychak.service.impl;


	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.security.core.userdetails.User;
	import org.springframework.security.core.userdetails.UserDetails;
	import org.springframework.security.core.userdetails.UserDetailsService;
	import org.springframework.security.core.userdetails.UsernameNotFoundException;
	import org.springframework.stereotype.Service;

import ua.strychak.repository.UserRepository;



	@Service//("userDetailsService")
	public class UserDetailsServiceImpl implements UserDetailsService {

		@Autowired
		private UserRepository userRepository;
		
		@Override
		public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
			ua.strychak.entity.User userEntity = userRepository.findByUsername(username);
			if(userEntity == null) {
				throw new UsernameNotFoundException("User with username '" + username + "' not found");
			}
					
			return User
					.builder()
						.username(userEntity.getUsername())
						.password(userEntity.getPassword())
						.authorities(userEntity.getRole())
					.build();
		}

	}

