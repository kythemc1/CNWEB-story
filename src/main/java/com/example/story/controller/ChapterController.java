package com.example.story.controller;

import com.example.story.entity.ChapterEntity;
import com.example.story.payload.request.AddChapterRequest;
import com.example.story.payload.response.ChapterResponse;
import com.example.story.repository.ChapterRepository;
import com.example.story.service.service.ChapterService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "/api/chapter")
public class ChapterController {
    private final ChapterService chapterService;

    private final ChapterRepository chapterRepository;

    public ChapterController(ChapterService chapterService, ChapterRepository chapterRepository) {
        this.chapterService = chapterService;
        this.chapterRepository = chapterRepository;
    }

    @PostMapping(value = "add-chapter")
    public ResponseEntity<?> addChapter(@RequestBody AddChapterRequest addChapterRequest){
        chapterService.addChapter(addChapterRequest);
        return ResponseEntity.ok("success");
    }

    @DeleteMapping(value = "delete-chapter/{id}")
    private ResponseEntity<?> deleteChapter(@PathVariable int id){
        chapterService.deleteChapter(id);
        return ResponseEntity.ok("success");
    }

    @GetMapping(value = "count-chapter/{name}")
    public ResponseEntity<?>  countByName(@PathVariable String name){
        return ResponseEntity.ok(chapterRepository.countByName(name));
    }
    @GetMapping(value = "get-list-chapter")
    private ResponseEntity<?> getListChapter(){
        List<ChapterResponse> list;
        list=chapterService.listChapter();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping(value = "get-details/{name}/{subName}")
    private ResponseEntity<?> getDetails(@PathVariable String name, @PathVariable String subName){
        ChapterResponse chapterResponse = chapterService.getChapter(name,subName);
        return new ResponseEntity<>(chapterResponse,HttpStatus.OK);
    }

}
