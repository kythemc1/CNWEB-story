package com.example.story.entity;

import lombok.*;
import javax.persistence.*;

@Entity
@Table(name = "Role")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RoleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "RoleId")
    private Long roleId;

    @Column(name = "roleName")
    @Enumerated(EnumType.STRING)
    private ERole roleName;

}
