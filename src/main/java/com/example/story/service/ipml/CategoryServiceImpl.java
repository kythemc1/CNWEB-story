package com.example.story.service.ipml;

import com.example.story.entity.CategoryEntity;
import com.example.story.repository.CategoryRepository;
import com.example.story.service.service.CategoryService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Optional<CategoryEntity> findByCategoryName(String category) {
//        Pageable pageable = PageRequest.of(1,1);
        return categoryRepository.findByName(category);
    }
}
