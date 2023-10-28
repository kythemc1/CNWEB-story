package com.example.story.payload.request;

import lombok.Getter;
import lombok.Setter;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;
@Getter
@Setter
public class AddStoryRequest {
    private Long storyId;

    private String name;

    private String alias;

    private String content;

    private String view;

    private String status;

    private String source;

    private String image;

    private String keyword;

    private String description;

    private Date create_at;

    private Date update_at;

    private String author;

    private String author_details;

    private Set<String> listCategory = new HashSet<>();
}
