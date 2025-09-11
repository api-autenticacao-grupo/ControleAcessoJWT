package com.example.gestaotech.domain.produto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ProdutoDto(
        @NotBlank(message = "Não é possível prosseguir sem nome.")
        String nmProduto,
        @NotBlank(message = "Não é possível prosseguir sem descrição.")
        String dsProduto,
        @DecimalMin (value = "0.01", message = "O valor deve ser maior que R$ 0.01")
        @NotNull(message = "Não é possível prosseguir sem preço.")
        Double vlProduto
) {
}
