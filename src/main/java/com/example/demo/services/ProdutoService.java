package com.example.demo.services;
import com.example.demo.models.ProdutoModel;
import com.example.demo.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    //POST criar
    public ProdutoModel criarProduto(ProdutoModel produtoModel){
        return produtoRepository.save(produtoModel);
    }

    //GET listar
    public List<ProdutoModel> findAll(){
        return produtoRepository.findAll();
    }

    //GET buscar por id
    public ProdutoModel buscarProduto(Long id){
        return produtoRepository.findById(id).get();
    }

    //PUT atualizar
    public ProdutoModel atualizarProduto(Long id, ProdutoModel produtoModel){
        ProdutoModel newProdutoModel = produtoRepository.findById(id).get();
        newProdutoModel.setId(produtoModel.getId());
        return produtoRepository.save(newProdutoModel);
    }

    //DELETE deletar por id
    public void deletarProduto(Long id){
        produtoRepository.deleteById(id);
    }

}

