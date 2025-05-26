package com.TechMantSPA.resenas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TechMantSPA.resenas.model.Resenas;
import com.TechMantSPA.resenas.repository.ResenaRepository;

@Service
public class ResenaServices {

    @Autowired
    private ResenaRepository resenaRepository;

    // Traer todos las reseñas
    public List<Resenas> findAll(){
        return resenaRepository.findAll();
    }

    public Resenas findById(Long id) {
        if (id == null) return null;
        return resenaRepository.findById(id).orElse(null);
    }

    public Resenas saveResena(Resenas resena) {
        if (resena == null) {
            return null;
        }
        return resenaRepository.save(resena);
    }

    public void deleteResena(Long id){
        resenaRepository.deleteById(id);
    }

    public Resenas updateResena(Long id, Resenas resena) {
        if (id == null || resena == null) {
            return null;
        }
        
        Resenas resenaUpdate = findById(id);
        if (resenaUpdate == null) {
            return null;
        }
        
        resenaUpdate.setFechaResena(resena.getFechaResena());
        resenaUpdate.setComentario(resena.getComentario());
        resenaUpdate.setCalificacion(resena.getCalificacion());
        return saveResena(resenaUpdate);
    }

}
