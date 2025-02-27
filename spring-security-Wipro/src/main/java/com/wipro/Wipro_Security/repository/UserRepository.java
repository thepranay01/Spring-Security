package com.wipro.Wipro_Security.repository;

import com.wipro.Wipro_Security.model.Userinfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<Userinfo,Integer> {
    Optional<Userinfo> findByName(String username);
}
