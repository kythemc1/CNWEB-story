package com.example.story.service.service;


import com.example.story.entity.ERole;
import com.example.story.entity.RoleEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface RoleService {
    Optional<RoleEntity> findByRoleName(ERole roleName);
}
