package com.example.story.controller;

import com.example.story.entity.FollowEntity;
import com.example.story.repository.FollowRepository;
import com.example.story.repository.StoryRepository;
import com.example.story.repository.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/api/follow")
public class FollowController {


    private final FollowRepository followRepository;
    public FollowController(FollowRepository followRepository) {
        this.followRepository = followRepository;
    }

    @PutMapping(value = "add-follow/{username}/{storyName}")
    private ResponseEntity<?> addFollow(@PathVariable String username, @PathVariable String storyName){
        FollowEntity followEntity = new FollowEntity();
        followEntity.setFollowId(0L);
        followEntity.setUsername(username);
        followEntity.setStoryName(storyName);
        followEntity.setUserEntity(null);
        followEntity.setStory(null);
        followRepository.save(followEntity);
        return ResponseEntity.ok("success");
    }
}
