package ua.strychak.service.cloudinary;

import org.springframework.web.multipart.MultipartFile;

public interface CloudinaryService {
	
	String uploadFile(MultipartFile file, String folder);

}
