package com.example.story.entity;

import lombok.*;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "report")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ReportEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long reportId;

    @Column(name = "massage")
    private String alias;

    @Column(name = "create_at")
    private Date create_at;

    @Column(name = "update_at")
    private Date update_at;

    @ManyToOne
    @JoinColumn(name = "chapterId")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private ChapterEntity chapter;

}
