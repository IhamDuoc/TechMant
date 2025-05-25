package com.TechMant.Categoria.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.TechMant.Categoria.model.Categoria;
import com.TechMant.Categoria.service.CategoriaService;

@RestController
@RequestMapping("api/v1/categoria")
public class CategoriaController {

    @Autowired
    private CategoriaService categortiaService;


    //Metodo para obtener todas las categorias del servicio+
    @GetMapping
    public ResponseEntity<List<Categoria>> listarCategorias() {
        //variable para almacenar el resultado del select 
        List<Categoria> categorias = categortiaService.obtenCategorias();
        //Pregunta si vienen registros o no 
        if (categorias.isEmpty()) {
            //si esta vacia pone el codigo 204
            return ResponseEntity.noContent().build();
        }
        //si esta no esta vacia 
        return ResponseEntity.ok(categorias);
    }

    //metodo para agregar pacientes
    @PostMapping
    public ResponseEntity<Categoria> agregarCategoria(@RequestBody Categoria cat) {
        // variable para almacenar el retorno del servicio
        Categoria categoria2 = categortiaService.agregarCategoria(cat);
        return ResponseEntity.status(HttpStatus.CREATED).body(categoria2);
    }


    //Metodo para buscar por su id 
    @GetMapping("{/id}")
    public ResponseEntity<Categoria> buscarPorId(@PathVariable Long id) {
        try {
            Categoria categoria2 = categortiaService.obtenerCategoriaPorId(id);
            return ResponseEntity.ok(categoria2);
        }
        catch (Exception e){
            return ResponseEntity.notFound().build();
        }

    }
    //REVISAR SI ESTA BIEN 

    //Metodo para eliminar un paciente en espesifico (por su ID)
    @DeleteMapping("{/id}")
    public  ResponseEntity<?> eliminarCategoria(@PathVariable long id) {
        try {
            categortiaService.elminarCategoria(id);
            return ResponseEntity.noContent().build();
        }catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }


}
