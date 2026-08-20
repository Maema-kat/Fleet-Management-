package com.fleetmanagement.backend.controller;

import com.fleetmanagement.backend.entity.Role;
import org.springframework.web.bind.annotation.*;
import com.fleetmanagement.backend.service.RoleService;

import java.util.List;

@RestController
@RequestMapping("/api/roles")
public class RoleController {
    private final RoleService roleService;

    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }
    @PostMapping
    public Role createRole(@RequestBody Role role) {
        return roleService.createRole(role);
    }
    @GetMapping
    public List<Role> getAllRoles() {
        return roleService.getAllRoles();
    }
    @GetMapping("/{id}")
    public Role getRoleById(@PathVariable Long id) {
        return roleService.getRoleById(id);
    }
    @PutMapping("/{id}")
    public Role updateRole(
            @PathVariable Long id,
            @RequestBody Role role) {

        return roleService.updateRole(id, role);
    }
    @DeleteMapping("/{id}")
    public void deleteRole(@PathVariable Long id) {
        roleService.deleteRole(id);
    }

}
