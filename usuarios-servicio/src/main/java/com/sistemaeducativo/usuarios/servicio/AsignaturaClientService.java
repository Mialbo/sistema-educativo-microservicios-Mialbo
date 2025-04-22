package com.sistemaeducativo.usuarios.servicio;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.List;
import java.util.Arrays;

@Service
public class AsignaturaClientService {

    private final RestTemplate restTemplate;

    public AsignaturaClientService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<Object> obtenerAsignaturas() {
        String url = "http://ASIGNATURAS-SERVICIO/api/asignaturas";
        Object[] asignaturas = restTemplate.getForObject(url, Object[].class);
        return Arrays.asList(asignaturas);
    }
}
