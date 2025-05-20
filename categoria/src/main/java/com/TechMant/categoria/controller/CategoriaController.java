package com.TechMant.categoria.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.TechMant.categoria.model.Categoria;
import com.TechMant.categoria.services.CategoriaServices;

@RestController
@RequestMapping("/api/v1/categoria")
public class CategoriaController {

    @Autowired
    private CategoriaServices categoriaServices;

    // ENDPOINT para obtener todas las categorias
    @GetMapping
    public ResponseEntity<List<Categoria>> getAllCategorias(){
        List<Categoria> categorias = categoriaServices.getAllCategorias();
        if(categorias.isEmpty()){
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.ok(categorias);
        } 
    }

    // ENDPOINT para obtener una categoria por id
    @GetMapping("/{id}")
    public ResponseEntity<Categoria> getCategoriaById(@PathVariable Long id){
        Categoria categoria = categoriaServices.getCategoriaById(id);
        if(categoria == null){
            return ResponseEntity.notFound().build();
        }else{
            return ResponseEntity.ok(categoria);
        }
    }

    // ENDPOINT para crear una categoria
    @PostMapping
    public ResponseEntity<Categoria> createCategoria(@RequestBody Categoria categoria){
        try {
            Categoria categoriaCreada = categoriaServices.createCategoria(categoria);
            return ResponseEntity.status(HttpStatus.CREATED).body(categoriaCreada);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    // ENDPOINT para actualizar una categoria
    @PutMapping("/{id}")
    public ResponseEntity<Categoria> updateCategoria(@PathVariable Long id, @RequestBody Categoria categoria){
        try {
            Categoria categoriaActualizada = categoriaServices.updateCategoria(id, categoria);
            return ResponseEntity.ok(categoriaActualizada);
        } catch (Exception e) {
            // TODO: handle exception
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategoria(@PathVariable Long id){
        try {
            categoriaServices.deleteCategoria(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            // TODO: handle exception
            return ResponseEntity.notFound().build();
        }
    }





}
