package com.example.gestaotech.domain.usuario;


import jakarta.validation.constraints.NotBlank;

public record UsuarioDto(
        @NotBlank(message = "Não é possível prosseguir sem nome.")
        String nmUser,
        @NotBlank(message = "Não é possível prosseguir sem email.")
        String emUser,
        @NotBlank(message = "Não é possível prosseguir sem senha.")
        String snUser,
        @NotBlank(message = "Não é possível prosseguir sem cpf.")
        String cpfUser
) {
}
