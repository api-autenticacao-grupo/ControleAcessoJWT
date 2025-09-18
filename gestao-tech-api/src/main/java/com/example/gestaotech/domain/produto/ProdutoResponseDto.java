package com.example.gestaotech.domain.produto;

//Resposta do Get
public record ProdutoResponseDto(Integer cdProduto, String nmProduto, String dsproduto, Double vlProduto) {
    public ProdutoResponseDto(Produto produto){
        this(produto.getCdProduto(), produto.getNmProduto(), produto.getDsProduto(), produto.getVlProduto());
    }
}
