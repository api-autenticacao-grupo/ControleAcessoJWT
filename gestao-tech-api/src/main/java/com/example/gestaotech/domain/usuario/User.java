package com.example.gestaotech.domain.usuario;


import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "TBUSER")
public class User implements UserDetails { //Criação da tabela User com as respectivas restrições.
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CDUSER")
    private Integer cdUser;
    @Column(name = "NMUSER")
    private String nmUser;
    @Column(name = "EMUSER")
    private String emUser;
    @Column(name = "SNUSER")
    private String snUser;
    @Column(name = "CPFUSER")
    private String cpfUser;
    @Column(name = "ROLEUSER")
    private UserRole roleUser;


    public User(String nmUser, String cpfUser, String snUser, String emUser, UserRole roleUser) {
        this.nmUser = nmUser;
        this.cpfUser = cpfUser;
        this.snUser = snUser;
        this.emUser = emUser;
        this.roleUser = roleUser;
    }

    // Controle de hierarquia
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if(this.roleUser == UserRole.ADMIN) return List.of(new SimpleGrantedAuthority("ROLE_ADMIN") , new SimpleGrantedAuthority("ROLE_USER"));
        else return List.of(new SimpleGrantedAuthority("ROLE_USER"));
    }

    @Override
    public String getPassword() {
        return "";
    }


    @Override
    public String getUsername() {
        return emUser;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
