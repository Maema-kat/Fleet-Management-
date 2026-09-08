package com.fleetmanagement.backend.service;
import com.fleetmanagement.backend.dto.UserRequest;
import com.fleetmanagement.backend.dto.UserResponse;
import com.fleetmanagement.backend.entity.Role;
import com.fleetmanagement.backend.entity.User;
import com.fleetmanagement.backend.repository.RoleRepository;
import com.fleetmanagement.backend.repository.UserRepository;
import org.springframework.stereotype.Service;

    @Service
    public class UserService {

        private final UserRepository userRepository;
        private final RoleRepository roleRepository;

        public UserService(UserRepository userRepository,
                           RoleRepository roleRepository) {
            this.userRepository = userRepository;
            this.roleRepository = roleRepository;
        }

        public UserResponse createUser(UserRequest request) {

            Role role = roleRepository.findById(request.getRoleId())
                    .orElseThrow(() -> new RuntimeException("Role not found"));

            User user = new User();

            user.setFirstName(request.getFirstName());
            user.setLastName(request.getLastName());
            user.setEmail(request.getEmail());
            user.setContactNumber(request.getContactNumber());
            user.setPasswordHash(request.getPassword());

            user.setRole(role);

            User savedUser = userRepository.save(user);

            return new UserResponse(
                    savedUser.getId(),
                    savedUser.getFirstName(),
                    savedUser.getLastName(),
                    savedUser.getEmail(),
                    savedUser.getContactNumber(),
                    savedUser.getRole().getName()
            );
        }
    }

