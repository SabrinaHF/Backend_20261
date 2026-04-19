package com.jb.supermercado.internal.produto.dto;

import com.jb.supermercado.internal.produto.enums.StatusProduto;

public record ProdutoResponseRecord (String nome, String descricao, double preco, Long quantidadeEstoque, StatusProduto status){

}
