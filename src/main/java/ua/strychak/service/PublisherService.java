package ua.strychak.service;

import java.util.List;

import ua.strychak.domain.PublisherDTO;

public interface PublisherService {
	
	void save (PublisherDTO publisherDTO);
	
	PublisherDTO findById(Long id);
	
	List<PublisherDTO> getAllPublishers();

}
