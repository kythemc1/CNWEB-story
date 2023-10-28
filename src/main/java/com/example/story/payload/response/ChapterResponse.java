package com.example.story.payload.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ChapterResponse {
    private Long id;
    private String name;
    private String content;
}
