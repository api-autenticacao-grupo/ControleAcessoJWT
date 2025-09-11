package com.example.gestaotech.domain.produto;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "TBPRODUTO")
public class Produto {
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CDPRODUTO")
    private Integer cdProduto;
    @Column(name = "NMPRODUTO")
    private String nmProduto;
    @Column(name = "DSPRODUTO")
    private String dsProduto;
    @Column(name = "VLPRODUTO")
    private Double vlProduto;

    public Produto(ProdutoDto data) {
        this.nmProduto = data.nmProduto();
        this.dsProduto = data.dsProduto();
        this.vlProduto = data.vlProduto();
    }
}
