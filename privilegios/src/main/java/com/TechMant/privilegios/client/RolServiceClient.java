package com.TechMant.privilegios.client;

import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.TechMant.privilegios.model.Rol;

@Service
public class RolServiceClient {
    private final RestTemplate restTemplate;
    private static final String ROL_SERVICE_URL = "http://localhost:8082/api/v1/rol"; // Rol en 8082

    public RolServiceClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Rol getRolById(Long idRol) {
        try {
            // Ajusta la URL para que coincida con el endpoint del controlador Rol: "/{id}"
            String url = ROL_SERVICE_URL + "/" + idRol; // Ej: http://localhost:8082/api/v1/rol/4
            return restTemplate.getForObject(url, Rol.class);
        } catch (HttpClientErrorException.NotFound e) {
            return null; // Rol no existe
        }
    }
}

