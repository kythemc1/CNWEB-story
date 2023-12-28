package com.example.story.repository;

import com.example.story.entity.FollowEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FollowRepository extends JpaRepository<FollowEntity,Long> {
    FollowEntity findByStoryName(String storyName);

}
