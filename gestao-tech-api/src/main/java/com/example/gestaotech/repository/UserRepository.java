package com.example.gestaotech.repository;

import com.example.gestaotech.domain.usuario.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface UserRepository extends JpaRepository<User, String> {
    UserDetails FindByEmUser(String emUser);

}
