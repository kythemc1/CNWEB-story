package com.example.story.repository;

import com.example.story.entity.ChapterEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChapterRepository extends JpaRepository<ChapterEntity,Long> {

    List<ChapterEntity> findByName(String name);

    ChapterEntity findBySubNameAndName(String name, String subName);

    int countByName(String name);
}
