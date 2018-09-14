package ua.strychak.service.impl;

import static ua.strychak.constants.ErrorMessages.RECORD_ALREADY_EXISTS;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import ua.strychak.config.jwt.JWTTokenProvider;
import ua.strychak.domain.UserDTO;
import ua.strychak.entity.User;
import ua.strychak.entity.enums.UserRole;
import ua.strychak.exceptions.UserServiceException;
import ua.strychak.repository.UserRepository;
import ua.strychak.service.UserService;
import ua.strychak.service.utils.ObjectMapperUtils;
import ua.strychak.service.utils.StringUtils;



@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private ObjectMapperUtils objectMapper;

	@Autowired
	private JWTTokenProvider jwtTokenProvider;

	@Autowired
	private AuthenticationManager authenticationManager;

//	@Autowired
//	private EmailService emailService;

	@Autowired
	private StringUtils stringUtils;

	@Autowired
	private UserService userService;

	@Override
	public void saveUser(UserDTO dto) {

		String verifyToken = stringUtils.generate(100);

		if (userRepository.existsByUsername(dto.getUsername())) {
			throw new UserServiceException(RECORD_ALREADY_EXISTS);
		} else {
			dto.setRole(UserRole.ROLE_USER);
			System.out.println("Password:" + dto.getPassword());
			dto.setPassword(passwordEncoder.encode(dto.getPassword()));
			System.out.println("Password2:" + dto.getPassword());

			User userEntity = objectMapper.map(dto, User.class);

			userEntity.setEmailVerificationToken(verifyToken);
			userEntity.setEmailVerificationStatus(Boolean.FALSE);
//			sendEmail(dto.getEmail(), verifyToken);
			userRepository.save(userEntity);

		}
	}

//	private void sendEmail(String email, String verifyToken) {
//		// String verifyUrl = "http://localhost:9999/verify?token=" + verifyToken;
//		String verifyUrl = getHostName() + "verifyToken=" + verifyToken;
//
//		Mail mail = new Mail();
//		mail.setTo(email);
//		mail.setSubject("Email successfully registered");
//		mail.setContent("Please verify your account , follow the link : " + verifyUrl);
//
//		emailService.sendMessage(mail);
//	}

	private String getHostName() {
		ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder
				.getRequestAttributes();
		HttpServletRequest request = requestAttributes.getRequest();

		// http://localhost:9999/
		return request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + "/";
	}

	@Override
	public String signin(String username, String password) {
		System.out.println(">>> " + username);
		authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		System.out.println(">>> " + username);
		return jwtTokenProvider.createToken(username, userRepository.findByUsername(username).getRole());
	}

	@Override
	public UserDTO getById(Long id) {
		User user = userRepository.findById(id).get();
		UserDTO dto = objectMapper.map(user, UserDTO.class);
		return dto;
	}

	@Override
	public List<UserDTO> getAllUsers() {
		List<User> users = userRepository.findAll();
		List<UserDTO> userDTO = objectMapper.mapAll(users, UserDTO.class);
		return userDTO;
	}

	@Override
	public boolean existsByUsername(String username) {
		return false;
	}

	@Override
	public UserDTO findByUsername(String username) {
		return objectMapper.map(userRepository.findByUsername(username), UserDTO.class);
	}

	@Override
	public void verifyEmail(String verifyToken) {
		User userEntity = userRepository.findByEmailVerificationToken(verifyToken);
		if (userEntity != null) {
			userEntity.setEmailVerificationToken(null);
			userEntity.setEmailVerificationStatus(Boolean.TRUE);
			userRepository.save(userEntity);
		}

	}


	@Override
	public UserDTO findByUserEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}
}
