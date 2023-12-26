package com.example.story.repository;

import com.example.story.entity.StoriesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface StoryRepository extends JpaRepository<StoriesEntity,Long> {
    boolean deleteByName(String name);

//    List<StoriesEntity> findByListCategoryContaining(String category);
    boolean existsByName(String name);

    StoriesEntity findByName(String name);

    List<StoriesEntity> findByNameContaining(String name);
//    @Query("SELECT e  from StoriesEntity e")
//    Page<StoriesEntity> findAll(Pageable pageable);

//    @Query( value = "SELECT * FROM story_category u WHERE u.Id = ?1", nativeQuery = true)
//    List<StoriesEntity> findStoriesEntityByCategoryId(Long id);

}
