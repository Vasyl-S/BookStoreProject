package ua.strychak.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.strychak.domain.PublisherDTO;
import ua.strychak.service.PublisherService;

@RestController
@RequestMapping("publishers")
public class PublisherController {

	@Autowired
	private PublisherService publisherService;

	@PostMapping
	public ResponseEntity<Void> addBook(@RequestBody PublisherDTO publisherDTO) {
		publisherService.save(publisherDTO);
		return new ResponseEntity<>(HttpStatus.CREATED);

	}

	@GetMapping("{pubisherId}")
	public ResponseEntity<PublisherDTO> getId(@PathVariable("pubisherId") Long id) {
		PublisherDTO publisherDTO = publisherService.findById(id);
		return new ResponseEntity<PublisherDTO>(publisherDTO, HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<List<PublisherDTO>> getBooks() {
		List<PublisherDTO> publisherDTOs = publisherService.getAllPublishers();
		return new ResponseEntity<List<PublisherDTO>>(publisherDTOs, HttpStatus.OK);
	}

}
