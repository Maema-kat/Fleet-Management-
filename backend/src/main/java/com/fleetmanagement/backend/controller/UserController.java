package com.fleetmanagement.backend.controller;
import com.fleetmanagement.backend.dto.UserRequest;
import com.fleetmanagement.backend.dto.UserResponse;
import com.fleetmanagement.backend.service.UserService;
import org.springframework.web.bind.annotation.*;

    @RestController
    @RequestMapping("/api/users")
    public class UserController {

        private final UserService userService;

        public UserController(UserService userService) {
            this.userService = userService;
        }

        @PostMapping
        public UserResponse createUser(@RequestBody UserRequest request) {
            return userService.createUser(request);
        }
    }


