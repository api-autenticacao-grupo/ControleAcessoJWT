package com.example.gestaotech.repository;

import com.example.gestaotech.domain.produto.Produto;
import com.example.gestaotech.domain.usuario.Usuario;
import org.hibernate.type.descriptor.converter.spi.JpaAttributeConverter;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProdutoRepository extends JpaAttributeConverter<Produto, Integer> {
    Optional<Produto> FindByCdProduto(Integer cdProduto);
    Optional<Produto>FindAllByCdProduto(Integer cdProduto);
}
