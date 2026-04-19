package com.jb.supermercado.internal.produto.service;


import com.jb.supermercado.config.exception.BusinessException;
import com.jb.supermercado.config.exception.RecursoNaoEncontradoException;
import com.jb.supermercado.internal.produto.dto.ProdutoRequestRecord;
import com.jb.supermercado.internal.produto.dto.ProdutoResponseRecord;
import com.jb.supermercado.internal.produto.entity.ProdutoEntity;
import com.jb.supermercado.internal.produto.mapper.ProdutoMapperRecord;
import com.jb.supermercado.internal.produto.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    private final ProdutoRepository produtoRepository;

    public ProdutoService (ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public void cadastroProduto(ProdutoRequestRecord produtoRequest) {

        boolean produtoJaCadastrado = this.produtoRepository.existsByNome(produtoRequest.nome());
        if (produtoJaCadastrado){
            throw new BusinessException("Produto ja cadastrado");
        }

        ProdutoEntity produtoEntity = ProdutoMapperRecord.requestToProdutoEntity(produtoRequest);
        this.produtoRepository.save(produtoEntity);
    }

    public List<ProdutoResponseRecord> listaProdutos (){
        List<ProdutoEntity> produtos = this.produtoRepository.findAll();
        return ProdutoMapperRecord.entityToProdutoResponse(produtos);

    }

    public ProdutoResponseRecord buscaProdutoPorId(Long id){
        ProdutoEntity produtoEntity = this.produtoRepository.findById(id).orElseThrow(()
                -> new RecursoNaoEncontradoException("Produto nao encontrado"));
        return ProdutoMapperRecord.entityToProdutoResponse(produtoEntity);
    }

    public void atualizarProduto(Long id, ProdutoRequestRecord produtoRequest) {
        ProdutoEntity produtoEntity = this.produtoRepository.findById(id).orElseThrow(()
                -> new RecursoNaoEncontradoException("Produto nao encontrado"));
        produtoEntity.setNome(produtoRequest.nome());
        produtoEntity.setDescricao(produtoRequest.descricao());
        produtoEntity.setPreco(produtoRequest.preco());
        produtoEntity.setQuantidadeEstoque(produtoRequest.quantidadeEstoque());
        produtoEntity.setStatus(produtoRequest.status());
        this.produtoRepository.save(produtoEntity);
    }

    public void removerProduto(Long id) {

        if (produtoRepository.existsById(id)) {
            throw new RecursoNaoEncontradoException("Produto nao encontrado");
        }
        this.produtoRepository.deleteById(id);
    }

}
