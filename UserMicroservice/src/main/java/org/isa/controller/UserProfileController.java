package org.isa.controller;

import lombok.RequiredArgsConstructor;
import org.isa.document.UserProfile;
import org.isa.dto.request.CreateUserRequestDto;
import org.isa.service.UserProfileService;
import static org.isa.config.RestApis.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping(USERPROFILE)
public class UserProfileController {
    private final UserProfileService userProfileService;

    @PostMapping(CREATE_USER)
    public ResponseEntity<Boolean> createUser(@RequestBody CreateUserRequestDto dto) {
        userProfileService.createUser(dto);
        return ResponseEntity.ok(true);
    }

    @GetMapping(GET_ALL)
    public ResponseEntity<List<UserProfile>> getAll() {
        return ResponseEntity.ok(userProfileService.getAll());
    }
}
