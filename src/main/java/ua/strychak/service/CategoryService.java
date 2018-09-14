package ua.strychak.service;

import java.util.List;

import ua.strychak.domain.CategoryDTO;

public interface CategoryService {

	void saveCategory(CategoryDTO dto);

	CategoryDTO findCategoryById(Long id);

	List<CategoryDTO> findAllCategories();

}
