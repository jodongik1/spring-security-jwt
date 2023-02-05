package org.dongikjo.security.jwt.repository;
import java.util.Optional;

import org.dongikjo.security.jwt.models.RefreshToken;
import org.dongikjo.security.jwt.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;
 
public interface RefreshTokenRepository extends JpaRepository<RefreshToken, Long> {
  Optional<RefreshToken> findByToken(String token); 
 
  @Modifying
  int deleteByUser(User user);
}
