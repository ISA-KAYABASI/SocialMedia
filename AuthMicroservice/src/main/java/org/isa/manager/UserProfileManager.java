package org.isa.manager;


import org.isa.dto.request.CreateUserRequestDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import static org.isa.config.RestApis.CREATE_USER;

@FeignClient(url = "http://localhost:9191/dev/v1/user-profile",name = "userProfileManager")
public interface UserProfileManager {

    @PostMapping(CREATE_USER)
     ResponseEntity<Boolean> createUser(@RequestBody CreateUserRequestDto dto);
}
