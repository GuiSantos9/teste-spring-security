package com.example.demo.controllers;

import com.example.demo.models.ProdutoModel;
import com.example.demo.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    //POST
    @PostMapping
    public ResponseEntity<ProdutoModel> criarProduto(@RequestBody ProdutoModel produtoModel){
        ProdutoModel request = produtoService.criarProduto(produtoModel);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri()
                .path("id")
                .buildAndExpand(request.getId()).toUri();
        return ResponseEntity.created(uri).body(request);
    }

    //GET
    @GetMapping
    public ResponseEntity<List<ProdutoModel>> findAll(){
        List<ProdutoModel> list = produtoService.findAll();
        return ResponseEntity.ok().body(list);
    }

    //GET {id}
    @GetMapping("{id}")
    public ProdutoModel buscarProduto(@PathVariable Long id){
        return produtoService.buscarProduto(id);
    }

    //PUT
    @PutMapping
    public ProdutoModel atualizarProduto(@PathVariable Long id, @RequestBody ProdutoModel produtoModel) {
        return produtoService.atualizarProduto(id, produtoModel);
    }

    //DELETE {id}
    @DeleteMapping("{id}")
    public ResponseEntity<?> deletarProduto(@PathVariable Long id){
        produtoService.deletarProduto(id);
        return ResponseEntity.noContent().build();
    }

}
