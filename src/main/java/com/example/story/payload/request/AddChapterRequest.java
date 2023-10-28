package com.example.story.payload.request;

import com.example.story.entity.StoriesEntity;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
public class AddChapterRequest {
    private Long chapterId;

    private String name;

    private String subName;

    private String alias;

    private String content;

    private String view;

    private String source_video;

    private String source_image;

    private Date create_at;

    private Date update_at;

    private StoriesEntity story;
}
