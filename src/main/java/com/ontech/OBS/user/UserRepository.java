package com.ontech.OBS.user;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {

  Optional<User> findByEmail(String email);

    List<User> findByRole(Role role);

  User findByIdAndRole(Integer id, Role role);
}
