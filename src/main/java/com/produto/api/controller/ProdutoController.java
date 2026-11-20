package com.produto.api.controller;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.produto.api.model.Produto;
import com.produto.api.repository.ProdutoRepository;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/produtos")
public class ProdutoController{

    @Autowired
    private ProdutoRepository produtoRepository;

    @GetMapping("/produto")
    public List<produto> listarProdutos() { return produtoRepository.findAll();}

    @PostMapping("/produto")
    public ResponseEntity<Produto> buscarporId(@PathVariable Long id){
        produtoRepository.save(produto);
        return new ResponseEntity.status(HttpStatus.CREATED).body(produto);
    }

    @GetMapping("/produto/{id}")
    public ResponseEntity<Produto> buscarPorId(@PathVariable Long id){
        return produtorepository.findById(id).map(ResponseEntity :: ok).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/produto/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id){
        if(!produtoRepository.existById(id)){
            return ResponseEntity.notFound().build();
        }
        produtoRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
