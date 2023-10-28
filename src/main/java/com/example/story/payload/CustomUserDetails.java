package com.example.story.payload;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import com.example.story.entity.UserEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import lombok.AllArgsConstructor;
import lombok.Data;
@Data
@AllArgsConstructor
public class CustomUserDetails implements UserDetails {
    private Long UserId;
    private String firstName;
    private String lastname;
    private String email;
    private Integer age;
    private String address;
    private  String username;
    @JsonIgnore
    private String password;
    private String phoneNumber;

    private Collection<? extends GrantedAuthority> authorities;
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }
    @Override
    public String getUsername() {
        return this.username;
    }
    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public static CustomUserDetails MapUserToUserDetail(UserEntity userEntity){
        List<GrantedAuthority> listAuthorities = userEntity.getListRoleEntity().stream()
                .map(roleEntity -> new SimpleGrantedAuthority(roleEntity.getRoleName().name()))
                .collect(Collectors.toList());
        List<GrantedAuthority> list =new ArrayList<>();

        return new CustomUserDetails(
                userEntity.getUserId(),
                userEntity.getFirstName(),
                userEntity.getLastname(),
                userEntity.getEmail(),
                userEntity.getAge(),
                userEntity.getAddress(),
                userEntity.getUsername(),
                userEntity.getPassword(),
                userEntity.getPhoneNumber(),
                listAuthorities
        );

    }


}