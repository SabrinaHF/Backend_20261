package com.jb.supermercado.internal.produto.dto;

import jakarta.validation.constraints.*;
import com.jb.supermercado.internal.produto.enums.StatusProduto;


public record ProdutoRequestRecord (

        @NotBlank(message = "Campo 'Nome' obrigatorio")
        String nome,

        @NotBlank(message = "Campo 'Descricao' obrigatorio")
        String descricao,

        @Positive
        double preco,

        @Min(0)
        Long quantidadeEstoque,

        @NotNull
        StatusProduto status

        ){

}
