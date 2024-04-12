package com.example.Fipe.service;
import java.io.FilePermission;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import com.example.Fipe.model.FipeEntity;
import com.example.Fipe.model.Fipee;
import com.example.Fipe.repository.FipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@org.springframework.stereotype.Service
public class Service {
    private final FipeRepository fipeRepository;
    @Autowired
    public Service(FipeRepository marcaRepository) {
        this.fipeRepository = marcaRepository;
    }
    private String consultarURL(String apiUrl){
        String dados = "";
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(apiUrl, String.class);
        if (responseEntity.getStatusCode().is2xxSuccessful()) {
            dados = responseEntity.getBody();
        } else {
            dados = "Error code: " + responseEntity.getStatusCode();
        }
        return dados;
    }
    public String searchMarcas() {
        return consultarURL("https://parallelum.com.br/fipe/api/v1/carros/marcas");
    }
    public String searchModelos(int id) {
        return consultarURL("https://parallelum.com.br/fipe/api/v1/carros/marcas/"+id+"/modelos");
    }
    public String searchAnos(int marca, int modelo) {
        return consultarURL("https://parallelum.com.br/fipe/api/v1/carros/marcas/"+marca+"/modelos/"+modelo+"/anos");
    }
    public String searchValor(int marca, int modelo, String ano) {
        return consultarURL("https://parallelum.com.br/fipe/api/v1/carros/marcas/"+marca+"/modelos/"+modelo+"/anos/"+ano);
    }
    public List<FipeEntity> takeMarcas(){
        String apiUrl = "https://parallelum.com.br/fipe/api/v1/carros/marcas";
        RestTemplate restTemplate = new RestTemplate();
        Fipee[] response = restTemplate.getForObject(apiUrl, Fipee[].class);
        return Objects.nonNull(response) ? arrayDados(response) : null;
    }
    public List<FipeEntity> arrayDados(Fipee[] array){
        List<FipeEntity> marcas = new ArrayList<>();
        Arrays.stream(array).forEach( item -> {
            FipeEntity marca = new FipeEntity();
            marca.setCodigo(item.getCodigo());
            marca.setNome(item.getNome());
            marcas.add(marca);
        });
        return marcas;
    }
    public void saveMarcas(){
        fipeRepository.saveAll(takeMarcas());
    }
    public void updateMarcas(FipeEntity marca){
        fipeRepository.save(marca);
    }
    public void deleteMarcas(FipeEntity marca){
        fipeRepository.delete(marca);
    }
}
