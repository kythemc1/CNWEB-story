package com.example.story.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "story")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class StoriesEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long storyId;

    @Column(name = "name")
    private String name;

    @Column(name = "alias")
    private String alias;

    @Column(name = "content")
    private String content;

    @Column(name = "view")
    private String view;

    @Column(name = "status")
    private String status;

    @Column(name = "source")
    private String source;

    @Column(name = "image")
    private String image;

    @Column(name = "keyword")
    private String keyword;

    @Column(name = "description")
    private String description;

    @Column(name = "create_at")
    private Date create_at;

    @Column(name = "update_at")
    private Date update_at;

    @Column(name = "author")
    private String author;

    @Column(name = "author_details")
    private String author_details;

    @OneToMany(mappedBy = "story", cascade = CascadeType.ALL)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Collection<ChapterEntity> chapters;

//    @OneToMany(mappedBy = "story", cascade = CascadeType.ALL)
//    @EqualsAndHashCode.Exclude
//    @ToString.Exclude
//    private Collection<Category_StoryEntity> categoryStoryEntities;

    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    @JoinTable(name = "story_category",
            joinColumns = @JoinColumn(name = "storyId"),
            inverseJoinColumns = @JoinColumn(name = "categoryId"))
    private Set<CategoryEntity> listCategory = new HashSet<>();
}
