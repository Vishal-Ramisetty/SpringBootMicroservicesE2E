package com.lcwd.rating.external.services;

import com.lcwd.rating.entity.Users;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Service
@FeignClient(name="USER-SERVICE")
public interface UserService {

    @GetMapping("/api/users/{userId}")
    Users findUserById(@PathVariable String userId);

    @PutMapping("/api/users/{userId}")
    Users updateUser(@PathVariable String userId, @RequestBody Users user);

}
