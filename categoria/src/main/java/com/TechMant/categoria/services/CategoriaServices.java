package com.TechMant.categoria.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TechMant.categoria.model.Categoria;
import com.TechMant.categoria.repository.CategoriaRepository;

@Service
public class CategoriaServices {

    @Autowired
    private CategoriaRepository categoriaRepository;

    // Método para ver todas las categorias
    public List<Categoria> getAllCategorias(){
        return categoriaRepository.findAll();
    }

    // Método para ver una categoria por id
    public Categoria getCategoriaById(Long id){
        return categoriaRepository.findById(id).orElseThrow(() -> new RuntimeException("Categoria no encontrada"));
    }

    // Método para crear una categoria 
    public Categoria createCategoria(Categoria categoria){
        return categoriaRepository.save(categoria);
    }

    // Método para actualizar una categoria
    public Categoria updateCategoria(Long id, Categoria categoria){
        Categoria categoriaActual = categoriaRepository.findById(id).orElseThrow(() -> new RuntimeException("Categoria no encontrada"));
        categoriaActual.setNombreCategoria(categoria.getNombreCategoria());
        return categoriaRepository.save(categoriaActual);
    }
    // Método para eliminar una categoria
    public void deleteCategoria(Long id){
        Categoria categoriaActual = categoriaRepository.findById(id).orElseThrow(() -> new RuntimeException("Categoria no encontrada"));
        categoriaRepository.delete(categoriaActual);
    }

}
