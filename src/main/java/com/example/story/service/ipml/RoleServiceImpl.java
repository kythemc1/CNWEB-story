package com.example.story.service.ipml;


import com.example.story.entity.ERole;
import com.example.story.entity.RoleEntity;
import com.example.story.repository.RoleRepository;
import com.example.story.service.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleRepository roleRepository;
    @Override
    public Optional<RoleEntity> findByRoleName(ERole roleName) {
        return roleRepository.findByRoleName(roleName);
    }
}
