package com.example.story.service.service;

import com.example.story.entity.CategoryEntity;
import org.springframework.stereotype.Service;


import java.util.Optional;

@Service
public interface CategoryService {
    Optional<CategoryEntity> findByCategoryName(String category);


}
