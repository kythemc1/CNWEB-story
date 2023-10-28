package com.example.story.repository;

import com.example.story.entity.ERole;
import com.example.story.entity.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<RoleEntity,Long> {
    Optional<RoleEntity> findByRoleName(ERole roleName);
//        boolean existsByRoleName(String username);
//
//        boolean existsByEmail(String email);

}
