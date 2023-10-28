package com.example.story.service.service;

import com.example.story.entity.StoriesEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface StoryService {
    void addStory(StoriesEntity storiesEntity) ;
    List<StoriesEntity> getAllStory(int page);

    List<StoriesEntity> sortByCategory(String category,int page);

    List<StoriesEntity> sortByName(int page);
    List<StoriesEntity> sortByTime(int page);
    void updateStory(StoriesEntity storiesEntity);

    void deleteStoryByName(String nameStory);
}
