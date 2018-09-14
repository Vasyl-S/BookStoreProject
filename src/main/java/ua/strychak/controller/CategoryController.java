package ua.strychak.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ua.strychak.domain.CategoryDTO;
import ua.strychak.service.CategoryService;


@RestController
@RequestMapping("categories")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;
	
	@PostMapping
	public ResponseEntity<Void> createCategory(@RequestBody CategoryDTO dto) {
		categoryService.saveCategory(dto);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
//	@GetMapping
//	public List<CategoryDTO> getCategories() {
//		return categoryService.findAllCategories();
//	}
	
	@GetMapping
	public ResponseEntity<List<CategoryDTO>> getCategories() {
		List<CategoryDTO> categoryDTOs = categoryService.findAllCategories();
		return new ResponseEntity<List<CategoryDTO>>(categoryDTOs, HttpStatus.OK);
	}
	
}