package org.dongikjo.security.jwt.repository;

import java.util.Optional;

import org.dongikjo.security.jwt.models.ERole;
import org.dongikjo.security.jwt.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
 
public interface RoleRepository extends JpaRepository<Role, Long> {
  Optional<Role> findByName(ERole name); 
}
