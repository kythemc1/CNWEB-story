package com.example.story.service.ipml;

import com.example.story.entity.CategoryEntity;
import com.example.story.entity.StoriesEntity;
import com.example.story.repository.CategoryRepository;
import com.example.story.repository.StoryRepository;
import com.example.story.service.service.StoryService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class StoryServiceImpl implements StoryService {
    private final StoryRepository storyRepository;

    private final CategoryRepository categoryRepository;

    public StoryServiceImpl(StoryRepository storyRepository, CategoryRepository categoryRepository) {
        this.storyRepository = storyRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void addStory(StoriesEntity storiesEntity) {

        storyRepository.save(storiesEntity);
    }

    @Override
    public List<StoriesEntity> getAllStory(int page) {
        List <StoriesEntity> list = new ArrayList<StoriesEntity>();
        Pageable pageable1 = PageRequest.of(page-1,10);

        for(int i =0;i<=9;i++){
            StoriesEntity storiesEntity =new StoriesEntity();
            storiesEntity.setStoryId(storyRepository.findAll(pageable1).getContent().get(9-i).getStoryId());
            storiesEntity.setAuthor(storyRepository.findAll(pageable1).getContent().get(9-i).getAuthor());
            storiesEntity.setAlias(storyRepository.findAll(pageable1).getContent().get(9-i).getAlias());
            storiesEntity.setContent(storyRepository.findAll(pageable1).getContent().get(9-i).getContent());
            storiesEntity.setImage(storyRepository.findAll(pageable1).getContent().get(9-i).getImage());
            storiesEntity.setKeyword(storyRepository.findAll(pageable1).getContent().get(9-i).getKeyword());
            storiesEntity.setName(storyRepository.findAll(pageable1).getContent().get(9-i).getName());
            storiesEntity.setAuthor_details(storyRepository.findAll(pageable1).getContent().get(9-i).getAuthor_details());
            storiesEntity.setCreate_at(storyRepository.findAll(pageable1).getContent().get(9-i).getCreate_at());
            storiesEntity.setUpdate_at(storyRepository.findAll(pageable1).getContent().get(9-i).getUpdate_at());
            storiesEntity.setView(storyRepository.findAll(pageable1).getContent().get(9-i).getView());
            storiesEntity.setSource(storyRepository.findAll(pageable1).getContent().get(9-i).getSource());
            storiesEntity.setStatus(storyRepository.findAll(pageable1).getContent().get(9-i).getStatus());
            storiesEntity.setDescription(storyRepository.findAll(pageable1).getContent().get(9-i).getDescription());
//            storiesEntity.setListCategory(storyRepository.findAll(pageable1).getContent().get(9-i).getListCategory());
            list.add(storiesEntity);
        }


        return list;
    }

    @Override
    public List<StoriesEntity> sortByCategory(String category,int page) {


        Optional<CategoryEntity> categoryEntityList = categoryRepository.findByName(category);

        List<StoriesEntity> storiesEntityList = new ArrayList<>();
            categoryEntityList.get().getStoriesEntities().forEach(storiesEntity -> {
                storiesEntityList.add(storiesEntity);
            });
        return storiesEntityList.subList((page-1)*10,page*10-1);
    }

    @Override
    public List<StoriesEntity> sortByName(int page) {
        List <StoriesEntity> list = new ArrayList<StoriesEntity>();
        Pageable pageable1 = PageRequest.of(page-1,10,Sort.by("name"));

        for(int i =0;i<=9;i++){
            StoriesEntity storiesEntity =new StoriesEntity();
            storiesEntity.setStoryId(storyRepository.findAll(pageable1).getContent().get(9-i).getStoryId());
            storiesEntity.setAuthor(storyRepository.findAll(pageable1).getContent().get(9-i).getAuthor());
            storiesEntity.setAlias(storyRepository.findAll(pageable1).getContent().get(9-i).getAlias());
            storiesEntity.setContent(storyRepository.findAll(pageable1).getContent().get(9-i).getContent());
            storiesEntity.setImage(storyRepository.findAll(pageable1).getContent().get(9-i).getImage());
            storiesEntity.setKeyword(storyRepository.findAll(pageable1).getContent().get(9-i).getKeyword());
            storiesEntity.setName(storyRepository.findAll(pageable1).getContent().get(9-i).getName());
            storiesEntity.setAuthor_details(storyRepository.findAll(pageable1).getContent().get(9-i).getAuthor_details());
            storiesEntity.setCreate_at(storyRepository.findAll(pageable1).getContent().get(9-i).getCreate_at());
            storiesEntity.setUpdate_at(storyRepository.findAll(pageable1).getContent().get(9-i).getUpdate_at());
            storiesEntity.setView(storyRepository.findAll(pageable1).getContent().get(9-i).getView());
            storiesEntity.setSource(storyRepository.findAll(pageable1).getContent().get(9-i).getSource());
            storiesEntity.setStatus(storyRepository.findAll(pageable1).getContent().get(9-i).getStatus());
            storiesEntity.setDescription(storyRepository.findAll(pageable1).getContent().get(9-i).getDescription());
            list.add(storiesEntity);
        }


        return list;
    }

    @Override
    public List<StoriesEntity> sortByTime(int page) {
        List <StoriesEntity> list = new ArrayList<StoriesEntity>();
        Pageable pageable1 = PageRequest.of(page-1,10, Sort.by("create_at"));

        for(int i =0;i<=9;i++){
            StoriesEntity storiesEntity =new StoriesEntity();
            storiesEntity.setStoryId(storyRepository.findAll(pageable1).getContent().get(9-i).getStoryId());
            storiesEntity.setAuthor(storyRepository.findAll(pageable1).getContent().get(9-i).getAuthor());
            storiesEntity.setAlias(storyRepository.findAll(pageable1).getContent().get(9-i).getAlias());
            storiesEntity.setContent(storyRepository.findAll(pageable1).getContent().get(9-i).getContent());
            storiesEntity.setImage(storyRepository.findAll(pageable1).getContent().get(9-i).getImage());
            storiesEntity.setKeyword(storyRepository.findAll(pageable1).getContent().get(9-i).getKeyword());
            storiesEntity.setName(storyRepository.findAll(pageable1).getContent().get(9-i).getName());
            storiesEntity.setAuthor_details(storyRepository.findAll(pageable1).getContent().get(9-i).getAuthor_details());
            storiesEntity.setCreate_at(storyRepository.findAll(pageable1).getContent().get(9-i).getCreate_at());
            storiesEntity.setUpdate_at(storyRepository.findAll(pageable1).getContent().get(9-i).getUpdate_at());
            storiesEntity.setView(storyRepository.findAll(pageable1).getContent().get(9-i).getView());
            storiesEntity.setSource(storyRepository.findAll(pageable1).getContent().get(9-i).getSource());
            storiesEntity.setStatus(storyRepository.findAll(pageable1).getContent().get(9-i).getStatus());
            storiesEntity.setDescription(storyRepository.findAll(pageable1).getContent().get(9-i).getDescription());
//            storiesEntity.setListCategory(storyRepository.findAll(pageable1).getContent().get(9-i).getListCategory());
            list.add(storiesEntity);
        }


        return list;
    }

    @Override
    public void updateStory(StoriesEntity storiesEntity) {

    }

    @Override
    public void deleteStoryByName(String nameStory) {

    }
}
