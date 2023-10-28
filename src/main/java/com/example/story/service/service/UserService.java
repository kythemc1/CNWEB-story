package com.example.story.service.service;


import com.example.story.dto.UserDto;
import com.example.story.entity.UserEntity;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public interface UserService {
    List<UserDto> getListUser();
    void userCreate(UserEntity userEntity);

    UserEntity loadUserByUsername(String username);

    boolean existByUsername(String username);

    boolean existByEmail(String email);

}
