package com.example.story.repository;


import com.example.story.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity,Long> {
    UserEntity findByUsername(String username);
    boolean existsByUsername(String username);

    boolean existsByEmail(String email);

}
