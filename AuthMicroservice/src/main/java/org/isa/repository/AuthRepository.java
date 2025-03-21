package org.isa.repository;

import org.isa.entity.Auth;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthRepository extends JpaRepository<Auth, Long> {

    Boolean existsByUserNameAndPassword(String userName, String password);

}
