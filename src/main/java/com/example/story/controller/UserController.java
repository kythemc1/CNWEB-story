package com.example.story.controller;

import com.example.story.dto.UserDto;
import com.example.story.entity.ERole;
import com.example.story.entity.RoleEntity;
import com.example.story.entity.UserEntity;
import com.example.story.payload.request.SignUpRequest;
import com.example.story.service.service.RoleService;
import com.example.story.service.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/api/users")
public class UserController {
    private final RoleService roleService;
    private final UserService userService;

    public UserController(RoleService roleService, UserService userService) {
        this.roleService = roleService;
        this.userService = userService;
    }

    @GetMapping(value = {"/get-all"})
    public ResponseEntity<?> getListUser() {
        List<UserDto> userDto = userService.getListUser();
        return ResponseEntity.ok(userDto);
    }

    @PostMapping(value = {"/create"})
    public ResponseEntity<?> createUser(@RequestBody SignUpRequest signUpRequest) {
        if (userService.existByUsername(signUpRequest.getUsername())){
            return ResponseEntity.badRequest().body("error : account exist");
        } else if (userService.existByEmail(signUpRequest.getEmail())) {
            return ResponseEntity.badRequest().body("ton tai email nay roi");
        }
        UserEntity userEntity =new UserEntity();
        userEntity.setUsername(signUpRequest.getUsername());
        userEntity.setPassword(signUpRequest.getPassword());
        userEntity.setEmail(signUpRequest.getEmail());
        userEntity.setAddress(signUpRequest.getAddress());
        userEntity.setAge(signUpRequest.getAge());
        userEntity.setFirstName(signUpRequest.getFirstName());
        userEntity.setLastname(signUpRequest.getLastname());
        userEntity.setPhoneNumber(signUpRequest.getPhoneNumber());
        Set<String> strRoles = signUpRequest.getListRole();
        Set<RoleEntity> listRole = new HashSet<>();
        if(strRoles==null){
            RoleEntity userRole = roleService.findByRoleName(ERole.ROLE_USER).orElseThrow(()->new RuntimeException("loi"));
                listRole.add(userRole);
        }
        else {
            strRoles.forEach(role->{
                switch (role){
                    case "admin" :
                        RoleEntity adminRole =roleService.findByRoleName(ERole.ROLE_ADMIN).orElseThrow(()->new RuntimeException("loi"));
                        listRole.add(adminRole);


                    case "moderator" :
                        RoleEntity moderator =roleService.findByRoleName(ERole.ROLE_MODERATOR).orElseThrow(()->new RuntimeException("loi"));
                        listRole.add(moderator);


                    case "user" :
                        RoleEntity userRole =roleService.findByRoleName(ERole.ROLE_USER).orElseThrow(()->new RuntimeException("loi"));
                        listRole.add(userRole);
                }
            });
        }
        userEntity.setListRoleEntity(listRole);
        userService.userCreate(userEntity);
        return ResponseEntity.ok("thanh cmn cong");
    }

    @PutMapping(value = {"/{id}"})
    public ResponseEntity<?> updateUser(@PathVariable String id) {
        return null;
    }

    @DeleteMapping(value = {"/users/{id}"})
    public ResponseEntity<?> deleteUser(@PathVariable String id) {
        return null;
    }
}
