package org.isa.service;

import lombok.RequiredArgsConstructor;
import org.isa.document.UserProfile;
import org.isa.dto.request.CreateUserRequestDto;
import org.isa.repository.UserProfileRepository;
import org.springframework.http.ProblemDetail;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserProfileService {
    private final UserProfileRepository userProfileRepository;

    public void createUser(CreateUserRequestDto dto) {
        userProfileRepository.save(UserProfile.builder()
                        .authId(dto.getAuthId())
                        .userName(dto.getUserName())
                        .email(dto.getEmail())
                .build());
    }

    public List<UserProfile> getAll() {
        return userProfileRepository.findAll();
    }
}
