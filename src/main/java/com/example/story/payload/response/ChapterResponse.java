package com.example.story.payload.response;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class ChapterResponse {
    private Long Id;

    private String name;

    private String subName;


    private String content;

    private String view;

    private String source_video;

    private String source_image;

}
