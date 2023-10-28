package com.example.story.controller;


import com.example.story.entity.RefreshTokenEntity;
import com.example.story.jwt.JwtTokenProvider;
import com.example.story.payload.CustomUserDetails;
import com.example.story.payload.request.LoginRequest;
import com.example.story.payload.request.TokenRefreshRequest;
import com.example.story.payload.response.JwtResponse;
import com.example.story.payload.response.TokenRefreshResponse;
import com.example.story.service.service.RefreshTokenService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("/api/auth")
@RestController
public class AuthController {
    private final RefreshTokenService refreshTokenService;
    private final AuthenticationManager authenticationManager;
    private final JwtTokenProvider jwtTokenProvider;
    public AuthController(RefreshTokenService refreshTokenService, AuthenticationManager authenticationManager, JwtTokenProvider jwtTokenProvider) {
        this.refreshTokenService = refreshTokenService;
        this.authenticationManager = authenticationManager;
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @PostMapping(value = {"/login"})
    public ResponseEntity login(@RequestBody LoginRequest loginRequest){
        Authentication authentication =authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getUsername(),
                        loginRequest.getPassword()
                )
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        CustomUserDetails customUserDetails = (CustomUserDetails) authentication.getPrincipal();
        String jwt = jwtTokenProvider.generateToken((CustomUserDetails) authentication.getPrincipal());
        List<String> listRole = customUserDetails.getAuthorities().stream().map(item -> item.getAuthority()).collect(Collectors.toList());
        RefreshTokenEntity refreshTokenEntity = refreshTokenService.createRefreshToken(customUserDetails.getUserId());
        return ResponseEntity.ok().body(new JwtResponse(jwt, customUserDetails.getFirstName(), customUserDetails.getLastname(), customUserDetails.getEmail(), customUserDetails.getAge(), customUserDetails.getUsername(), customUserDetails.getPhoneNumber(), listRole, refreshTokenEntity.getRefreshToken()));
    }

    @PostMapping(value = {"/refresh-token"})
    public ResponseEntity<?> refreshToken(@Valid @RequestBody TokenRefreshRequest request) {
        String requestRefreshToken = request.getRefreshToken();

        return refreshTokenService.findByToken(requestRefreshToken)
                .map(refreshTokenService::verifyExpiration)
                .map(RefreshTokenEntity::getUserEntity)
                .map(userEntity -> {
                    String token = jwtTokenProvider.generateTokenFromUsername(userEntity.getUsername());
                    return ResponseEntity.ok(new TokenRefreshResponse(token, requestRefreshToken));
                })
                .orElseThrow(() -> null);
    }
}


