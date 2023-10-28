package com.example.story.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StoryDto {
    private Long storyId;

    private String name;


    private String content;

    private String status;

    private String source;

    private String image;

    private String keyword;

    private String description;

    private Date create_at;

    private Date update_at;

    private Set<String> listCategory;

}
