package com.example.story.service.ipml;

import com.example.story.entity.ChapterEntity;
import com.example.story.entity.FollowEntity;
import com.example.story.entity.UserEntity;
import com.example.story.payload.request.AddChapterRequest;
import com.example.story.payload.response.ChapterResponse;
import com.example.story.repository.ChapterRepository;
import com.example.story.repository.FollowRepository;
import com.example.story.repository.StoryRepository;
import com.example.story.repository.UserRepository;
import com.example.story.service.service.ChapterService;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ChapterServiceImpl implements ChapterService {
    private final ChapterRepository chapterRepository;
    private final StoryRepository storyRepository;
    private final FollowRepository followRepository;
    private final UserRepository userRepository;

    private final JavaMailSender emailSender;

    public ChapterServiceImpl(ChapterRepository chapterRepository, StoryRepository storyRepository, FollowRepository followRepository, UserRepository userRepository, JavaMailSender emailSender) {
        this.chapterRepository = chapterRepository;
        this.storyRepository = storyRepository;
        this.followRepository = followRepository;
        this.userRepository = userRepository;
        this.emailSender = emailSender;
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


        chapterEntity.setStory(storyRepository.findByName(addChapterRequest.getStoryName()));

        chapterRepository.save(chapterEntity);
//        List<FollowEntity> list=new ArrayList<>();
//        FollowEntity f=followRepository.findByStoryName(chapterEntity.getName());
        List<UserEntity> listUser= new ArrayList<>();
//        for (FollowEntity followEntity: f
//             ) {
            listUser=userRepository.findAll();
//        }
        for (UserEntity userEntity:listUser
             ) {
            SimpleMailMessage message = new SimpleMailMessage();

            message.setTo(userEntity.getEmail());
            message.setSubject("Da cap Nhap Chap moi nhat cua");

            message.setText(chapterEntity.getName());
            emailSender.send(message);
        }
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
    public ChapterResponse getChapter(String name,String subName) {
        List<ChapterEntity> list= chapterRepository.findByName(name);
        ChapterEntity e = new ChapterEntity();
        for (ChapterEntity chapterentity: list
             ) {
            if(subName.equals(chapterentity.getSubName())){
                e=chapterentity;
            }
        }
        ChapterResponse chapterResponse =new ChapterResponse();
        chapterResponse.setId(e.getChapterId());
        chapterResponse.setView(e.getView());
        chapterResponse.setSubName(e.getSubName());
        chapterResponse.setSource_image(e.getSource_image());
        chapterResponse.setContent(e.getContent());
        chapterResponse.setSource_video(e.getSource_video());
        chapterResponse.setName(e.getName());
        return chapterResponse;
    }
}
