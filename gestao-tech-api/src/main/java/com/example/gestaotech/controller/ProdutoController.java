package com.example.gestaotech.controller;

import com.example.gestaotech.domain.produto.Produto;
import com.example.gestaotech.domain.produto.ProdutoDto;
import com.example.gestaotech.domain.produto.ProdutoResponseDto;
import com.example.gestaotech.repository.ProdutoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("produto")
public class ProdutoController {

    @Autowired
    ProdutoRepository repository;

    @PostMapping
    public ResponseEntity postProduto(@RequestBody @Valid ProdutoDto body){
        Produto novoProduto = new Produto(body);

        this.repository.save(novoProduto);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity getAllProdutos(){
        List<ProdutoResponseDto> produtoList = this.repository.findAll().stream().map(ProdutoResponseDto::new).toList();
        return ResponseEntity.ok(produtoList);
    }
}
