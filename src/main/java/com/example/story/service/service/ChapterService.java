package com.example.story.service.service;

import com.example.story.entity.ChapterEntity;
import com.example.story.payload.request.AddChapterRequest;
import com.example.story.payload.response.ChapterResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ChapterService {
    void addChapter(AddChapterRequest addChapterRequest);
    boolean deleteChapter(int id);

    List<ChapterResponse> listChapter();

    ChapterEntity getChapter(String name);
}
