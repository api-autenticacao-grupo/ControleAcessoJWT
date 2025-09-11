package com.example.gestaotech.domain.usuario;


import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Cleanup;
import lombok.Data;
import lombok.NoArgsConstructor;



@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "TBUSER")
public class Usuario {
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CDUSER")
    private Integer cdUser;
    @Column(name = "NMUSER")
    private String nmUser;
    @Column(name = "EMUSER")
    @Email private String emUser;
    @Column(name = "SNUSER")
    private String snUser;
    @Column(name = "CPFUSER")
    @Pattern
   (regexp = "\\d{11}") private String cpfUser;
    @Column(name = "ROLEUSER")
    private String roleUser;
}
