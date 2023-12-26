package com.example.story.service.ipml;


import com.example.story.dto.UserDto;
import com.example.story.entity.UserEntity;
import com.example.story.repository.UserRepository;
import com.example.story.service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final JavaMailSender emailSender;
    @Autowired
    private PasswordEncoder encoder;


    public UserServiceImpl(UserRepository userRepository, JavaMailSender emailSender) {
        this.userRepository = userRepository;
        this.emailSender = emailSender;
    }

    @Override
    public List<UserDto> getListUser() {
        List<UserDto> listUserDto=new ArrayList<UserDto>();
        List<UserEntity> listUserEntity = userRepository.findAll();
        for (UserEntity userEntity: listUserEntity){
            UserDto userDto =new UserDto();
            userDto.setUsername(userEntity.getUsername());
            userDto.setAge(userEntity.getAge());
            userDto.setFirstName(userEntity.getFirstName());
            userDto.setLastname(userEntity.getLastname());
            userDto.setAddress(userEntity.getAddress());
            userDto.setEmail(userEntity.getEmail());
            userDto.setPhoneNumber(userEntity.getPhoneNumber());
            listUserDto.add(userDto);
        }

        return listUserDto;
    }

    @Override
    public void userCreate(UserEntity userEntity) {
        SimpleMailMessage message = new SimpleMailMessage();

        message.setTo(userEntity.getEmail());
        message.setSubject("mat khau cua ban la");

        // mật khẩu mặc định là 1234
        message.setText("1234");

        // Send Message!
        userEntity.setPassword(encoder.encode(userEntity.getPassword()));
        emailSender.send(message);
        userRepository.save(userEntity);
    }

    @Override
    public UserEntity loadUserByUsername(String username) {
        return null;
    }

    @Override
    public boolean existByUsername(String username) {
        return userRepository.existsByUsername(username);
    }

    @Override
    public boolean existByEmail(String email) {
        return userRepository.existsByEmail(email);
    }

}
