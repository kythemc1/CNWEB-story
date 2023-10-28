package com.example.story.entity;

import lombok.*;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;

@Entity
@Table(name = "chapter")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ChapterEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long chapterId;

    @Column(name = "name")
    private String name;

    @Column(name = "subName")
    private String subName;

    @Column(name = "alias")
    private String alias;

    @Column(name = "content")
    private String content;

    @Column(name ="view")
    private String view;

    @Column(name = "source_video")
    private String source_video;


    @Column(name = "source_image")
    private String source_image;

    @Column(name = "create_at")
    private Date create_at;

    @Column(name = "update_at")
    private Date update_at;
    @ManyToOne
    @JoinColumn(name = "storyId")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private StoriesEntity story;

    @OneToMany(mappedBy = "chapter", cascade = CascadeType.ALL)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Collection<ReportEntity> reports;

}
