package org.isa.service;

import lombok.RequiredArgsConstructor;
import org.isa.dto.request.LoginResponseDto;
import org.isa.dto.request.RegisterRequestDto;
import org.isa.entity.Auth;
import org.isa.repository.AuthRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final AuthRepository repository;


    public Auth register(RegisterRequestDto dto) {
        return repository.save(Auth.builder()
                        .userName(dto.getUserName())
                        .password(dto.getPassword())
                        .email(dto.getEmail())
                .build());
    }

    public Boolean login(LoginResponseDto dto) {
        return repository.existsByUserNameAndPassword(dto.getUserName(),dto.getPassword());

    }
}
