package org.isa.controller;

import lombok.RequiredArgsConstructor;
import static org.isa.config.RestApis.*;
import org.isa.dto.request.LoginResponseDto;
import org.isa.dto.request.RegisterRequestDto;
import org.isa.entity.Auth;
import org.isa.service.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
@RequestMapping(AUTHSERVICE)
public class AuthController {
    private final AuthService authService;

    @PostMapping(REGISTER)
    public ResponseEntity<Auth> register(@RequestBody RegisterRequestDto dto) {
        if (!dto.getPassword().equals(dto.getRepassword())){
            throw new RuntimeException("Passwords do not match");
        }else{
            return ResponseEntity.ok(authService.register(dto));
        }
    }

    @PostMapping(LOGIN)
    public ResponseEntity<Boolean> login(@RequestBody LoginResponseDto dto) {
        Boolean result = authService.login(dto);
        return ResponseEntity.ok(result);
    }
}
