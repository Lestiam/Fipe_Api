package com.example.Fipe;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class Service {

    private String consultaURL(String apiURL) {
        String dados = "";
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(apiURL, String.class);
        if (responseEntity.getStatusCode().is2xxSuccessful()) {
            dados = responseEntity.getBody();
        } else {
            dados = "\"Falha ao obter dados. Código de status: " + responseEntity.getStatusCode();
        }
        return dados;
    }
    public String consultaMarcas() {
        return consultaURL("https://parallelum.com.br/fipe/api/v1/carros/marcas");
    }
    public String consultarModelos(int id) {
        return consultaURL("https://parallelum.com.br/fipe/api/v1/carros/marcas/"+id+"/modelos");
    }

    public String consultarAnos(int marca, int modelo) {
        return consultaURL("https://parallelum.com.br/fipe/api/v1/carros/marcas/"+marca+"/modelos/"+modelo+"/anos");
    }

    public String consultarValor(int marca, int modelo, String ano) {
        return consultaURL("https://parallelum.com.br/fipe/api/v1/carros/marcas/"+marca+"/modelos/"+modelo+"/anos/"+ano);
    }
}
