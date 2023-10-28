package com.example.story.controller;

import com.example.story.payload.request.AddChapterRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/api/chapter")
public class ChapterController {

    @PostMapping(value = "add-chapter")
    public ResponseEntity<?> addChapter(@RequestBody AddChapterRequest addChapterRequest){
        return null;
    }

    @DeleteMapping(value = "delete-chapter/{id}")
    private ResponseEntity<?> deleteChapter(@PathVariable int id){
        return null;
    }

    @GetMapping(value = "get-list-chapter")
    private ResponseEntity<?> getListChapter(){
        return null;
    }

    @GetMapping(value = "get-details/{name}")
    private ResponseEntity<?> getDetails(@PathVariable String name){
        return null;
    }
}
