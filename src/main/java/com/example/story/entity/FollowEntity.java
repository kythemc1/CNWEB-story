package com.example.story.entity;

import lombok.*;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "follow")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class FollowEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long FollowId;

    private String username;
    private String storyName;
    @ManyToOne
    @JoinColumn(name = "username",insertable=false, updatable=false)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private UserEntity userEntity;

    @ManyToOne
    @JoinColumn(name = "storyName",insertable=false, updatable=false)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private StoriesEntity story;
}
