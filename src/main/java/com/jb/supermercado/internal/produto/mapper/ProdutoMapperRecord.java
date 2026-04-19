package com.jb.supermercado.internal.produto.mapper;

import com.jb.supermercado.internal.produto.entity.ProdutoEntity;
import com.jb.supermercado.internal.produto.dto.ProdutoRequestRecord;
import com.jb.supermercado.internal.produto.dto.ProdutoResponseRecord;
import com.jb.supermercado.internal.usuario.dto.UsuarioResponseRecord;

import java.util.ArrayList;
import java.util.List;

public class ProdutoMapperRecord {

        public static ProdutoEntity requesttoProdutoEntity(ProdutoRequestRecord produtoRequest) {

            ProdutoEntity produtoEntity = new ProdutoEntity();

            produtoEntity.setNome(produtoRequest.nome());
            produtoEntity.setDescricao(produtoRequest.descricao());
            produtoEntity.setPreco(produtoRequest.preco());
            produtoEntity.setQuantidadeEstoque(produtoRequest.quantidadeEstoque());
            produtoEntity.setStatus(produtoRequest.status());

            return produtoEntity;
        }

        public static ProdutoResponseRecord entitytoProdutoResponse(ProdutoEntity produtoEntity) {

            return new ProdutoResponseRecord(
                    produtoEntity.getId(),
                    produtoEntity.getNome(),
                    produtoEntity.getDescricao(),
                    produtoEntity.getPreco(),
                    produtoEntity.getQuantidadeEstoque(),
                    produtoEntity.getStatus());

        }

        public static List<ProdutoResponseRecord> entitytoProdutoResponse(List<ProdutoEntity> produtoEntityList){

            List<ProdutoResponseRecord> produtoResponseRecordArrayList = new ArrayList<>();
            for(ProdutoEntity produtoEntity : produtoEntityList){
                produtoResponseRecordArrayList.add(entitytoProdutoResponse(produtoEntity));
            }

            return produtoResponseRecordArrayList;

        }

}
