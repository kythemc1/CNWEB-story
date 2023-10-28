package com.example.story.payload;

import com.example.story.entity.UserEntity;
import com.example.story.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailService implements UserDetailsService {
    private final UserRepository userRepository;

    public CustomUserDetailService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity userEntity =userRepository.findByUsername(username);
        if(userEntity == null){
            throw new UsernameNotFoundException("khong tim thay");
        }
        return CustomUserDetails.MapUserToUserDetail(userEntity);
    }
}
