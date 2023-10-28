package com.example.story.service.service;

import java.time.Instant;
import java.util.Optional;
import java.util.UUID;

import com.example.story.entity.RefreshTokenEntity;
import com.example.story.repository.RefreshTokenRepository;
import com.example.story.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public interface RefreshTokenService {


     Optional<RefreshTokenEntity> findByToken(String token);

    RefreshTokenEntity createRefreshToken(Long userId) ;

    RefreshTokenEntity verifyExpiration(RefreshTokenEntity refreshToken);

}
