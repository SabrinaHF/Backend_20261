package com.jb.supermercado.internal.produto.repository;


import com.jb.supermercado.internal.produto.entity.ProdutoEntity;
import com.jb.supermercado.internal.produto.enums.StatusProduto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProdutoRepository extends JpaRepository<ProdutoEntity, Long> {
    ProdutoEntity findByNome(String nome);
    Boolean existsByNome(String nome);
    List<ProdutoEntity> findByStatus(StatusProduto status);
}
