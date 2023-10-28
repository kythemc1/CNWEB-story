package com.example.story.controller;

import com.example.story.entity.CategoryEntity;
import com.example.story.entity.StoriesEntity;
import com.example.story.payload.request.AddStoryRequest;
import com.example.story.repository.CategoryRepository;
import com.example.story.repository.StoryRepository;
import com.example.story.service.service.CategoryService;
import com.example.story.service.service.StoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/api/story")
public class StoryController {
    private final StoryService storyService;

    private final StoryRepository storyRepository;

    private final CategoryRepository categoryRepository;

    private final CategoryService categoryService;


    public StoryController(StoryService storyService, StoryRepository storyRepository, CategoryRepository categoryRepository, CategoryService categoryService) {
        this.storyService = storyService;
        this.storyRepository = storyRepository;
        this.categoryRepository = categoryRepository;
        this.categoryService = categoryService;
    }

    @GetMapping(value = "get-all/{page}")
    public ResponseEntity<?> getAllStory(@PathVariable ("page") int page){
            List<StoriesEntity> list = storyService.getAllStory(page);
        System.out.println("asdasdddd"+list);

        return new ResponseEntity<>(list, HttpStatus.OK);

    }

    @PostMapping(value = "add-story")
    public ResponseEntity<?> addStory(@RequestBody AddStoryRequest addStoryRequest){
        if (storyRepository.existsByName(addStoryRequest.getName()))
        {
            return  ResponseEntity.badRequest().body("add fail");
        }
            StoriesEntity storiesEntity = new StoriesEntity();
        storiesEntity.setStoryId(addStoryRequest.getStoryId());
        storiesEntity.setAuthor(addStoryRequest.getAuthor());
        storiesEntity.setAlias(addStoryRequest.getAlias());
        storiesEntity.setContent(addStoryRequest.getContent());
        storiesEntity.setImage(addStoryRequest.getImage());
        storiesEntity.setKeyword(addStoryRequest.getKeyword());
        storiesEntity.setName(addStoryRequest.getName());
        storiesEntity.setAuthor_details(addStoryRequest.getAuthor_details());
        storiesEntity.setCreate_at(addStoryRequest.getCreate_at());
        storiesEntity.setUpdate_at(addStoryRequest.getUpdate_at());
        storiesEntity.setView(addStoryRequest.getView());
        storiesEntity.setSource(addStoryRequest.getSource());
        storiesEntity.setStatus(addStoryRequest.getStatus());
        storiesEntity.setDescription(addStoryRequest.getDescription());
        Set<CategoryEntity> categoryEntities=new HashSet<>();
        Set<String> strCategory = addStoryRequest.getListCategory();
        strCategory.forEach(category->{
            CategoryEntity categoryEntity = categoryService.findByCategoryName(category).orElseThrow(()->new RuntimeException("loi"));
            categoryEntities.add(categoryEntity);
        });
            storiesEntity.setListCategory(categoryEntities);
            storyService.addStory(storiesEntity);
            return ResponseEntity.ok("add success");
    }

    @GetMapping(value = "sort-by-category/{category}/{page}")
    public ResponseEntity<?>  sortByCategory(@PathVariable String category ,@PathVariable int page){

            System.out.println(category);

            List<StoriesEntity> list=storyService.sortByCategory(category,page);

        return new ResponseEntity<>(list, HttpStatus.OK);
        }

    @GetMapping(value = "sort-by-category/{page}")
    public ResponseEntity<?>  sortByName(@PathVariable int page){


        List<StoriesEntity> list=storyService.sortByName(page);

        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping(value = "sort-by-category/{page}")
    public ResponseEntity<?>  sortByTime(@PathVariable int page){

        List<StoriesEntity> list=storyService.sortByTime(page);

        return new ResponseEntity<>(list, HttpStatus.OK);
    }

//    @PostMapping(value = "update-story")
//    public ResponseEntity<?> updateStory()

    @DeleteMapping(value = "delete/{id}")
    private ResponseEntity<?> deleteByName(@PathVariable int id){
        storyRepository.deleteById((long) id);
        return ResponseEntity.ok("successfully");
    }


}
