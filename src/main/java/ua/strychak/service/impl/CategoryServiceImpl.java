package ua.strychak.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.strychak.domain.CategoryDTO;
import ua.strychak.entity.Category;
import ua.strychak.repository.CategoryRepository;
import ua.strychak.service.CategoryService;
import ua.strychak.service.utils.ObjectMapperUtils;


@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private ObjectMapperUtils modelMapper;
	
	@Override
	public void saveCategory(CategoryDTO dto) {
		Category category = modelMapper.map(dto, Category.class);
		categoryRepository.save(category);
	}

	@Override
	public CategoryDTO findCategoryById(Long id) {
		Category category = categoryRepository.findById(id).get();
		CategoryDTO categoryDTO = modelMapper.map(category, CategoryDTO.class);
		return categoryDTO;
		//return modelMapper.map(categoryRepository.findById(id).get(), CategoryDTO.class);
	}

	@Override
	public List<CategoryDTO> findAllCategories() {
		List<Category> categories = categoryRepository.findAll();
		List<CategoryDTO> categoryDTOs = modelMapper.mapAll(categories, CategoryDTO.class);
		return categoryDTOs;
	}

}
