package com.jb.supermercado.internal.produto.dto;

import com.jb.supermercado.internal.produto.enums.StatusProduto;

public record ProdutoResponseRecord (Long id, String nome, String descricao, double preco, Long quantidadeEstoque, StatusProduto status){

}
