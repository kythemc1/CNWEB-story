package com.example.story.service.ipml;

import com.example.story.entity.ChapterEntity;
import com.example.story.payload.request.AddChapterRequest;
import com.example.story.payload.response.ChapterResponse;
import com.example.story.repository.ChapterRepository;
import com.example.story.service.service.ChapterService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ChapterServiceImpl implements ChapterService {
    private final ChapterRepository chapterRepository;

    public ChapterServiceImpl(ChapterRepository chapterRepository) {
        this.chapterRepository = chapterRepository;
    }

    @Override
    public void addChapter(AddChapterRequest addChapterRequest) {
        ChapterEntity chapterEntity =new ChapterEntity();
        chapterEntity.setChapterId(addChapterRequest.getChapterId());
        chapterEntity.setAlias(addChapterRequest.getAlias());
        chapterEntity.setContent(addChapterRequest.getContent());
        chapterEntity.setCreate_at(addChapterRequest.getCreate_at());
        chapterEntity.setName(addChapterRequest.getName());
        chapterEntity.setSource_image(addChapterRequest.getSource_image());
        chapterEntity.setSource_video(addChapterRequest.getSource_video());
        chapterEntity.setSubName(addChapterRequest.getSubName());
        chapterEntity.setUpdate_at(addChapterRequest.getUpdate_at());
        chapterEntity.setView(addChapterRequest.getView());
        chapterEntity.setStory(addChapterRequest.getStory());

        chapterRepository.save(chapterEntity);

    }

    @Override
    public boolean deleteChapter(int id) {
        chapterRepository.deleteById(Long.valueOf(id));
        return true;
    }

    @Override
    public List<ChapterResponse> listChapter() {
        List<ChapterEntity> chapterEntityList =new ArrayList<>();
        chapterEntityList= chapterRepository.findAll();
        List<ChapterResponse> listChapterResponses =new ArrayList<>();
        chapterEntityList.forEach(chapterEntity -> {
            ChapterResponse chapterResponse =new ChapterResponse();
            chapterResponse.setName(chapterEntity.getName());
            chapterResponse.setContent(chapterEntity.getContent());
            chapterResponse.setId(chapterEntity.getChapterId());
            listChapterResponses.add(chapterResponse);
        });
        return listChapterResponses;
    }

    @Override
    public ChapterEntity getChapter(String name) {
        return chapterRepository.findByName(name);
    }
}
