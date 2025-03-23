package org.isa.service;

import lombok.RequiredArgsConstructor;
import org.isa.dto.request.CreateUserRequestDto;
import org.isa.dto.request.LoginResponseDto;
import org.isa.dto.request.RegisterRequestDto;
import org.isa.entity.Auth;
import org.isa.manager.UserProfileManager;
import org.isa.repository.AuthRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final AuthRepository repository;
    private final UserProfileManager userProfileManager;


    public Auth register(RegisterRequestDto dto) {
        Auth auth= repository.save(Auth.builder()
                        .userName(dto.getUserName())
                        .password(dto.getPassword())
                        .email(dto.getEmail())
                .build());
        userProfileManager.createUser(CreateUserRequestDto.builder()
                        .authId(auth.getId())
                        .email(auth.getEmail())
                        .userName(auth.getUserName())
                .build());
        return auth;
    }

    public Boolean login(LoginResponseDto dto) {
        return repository.existsByUserNameAndPassword(dto.getUserName(),dto.getPassword());

    }
}
