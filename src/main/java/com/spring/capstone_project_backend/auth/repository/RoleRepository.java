package com.spring.capstone_project_backend.auth.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.capstone_project_backend.auth.entity.ERole;
import com.spring.capstone_project_backend.auth.entity.Role;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    
	Optional<Role> findByRoleName(ERole roleName);


}
