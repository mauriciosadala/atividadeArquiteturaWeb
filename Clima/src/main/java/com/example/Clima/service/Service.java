package com.example.Clima.service;
import com.example.Clima.ClimaClima;
import com.example.Clima.model.ClimaModel;
import com.example.Clima.repository.RepositoryClima;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;
import java.util.List;
import java.util.Objects;
@org.springframework.stereotype.Service
public class Service {

    @Autowired
    private RepositoryClima climaRepository;

    public ClimaClima preverTempo() {
        String apiUrl = "https://apiadvisor.climatempo.com.br/api/v1/anl/synoptic/locale/BR?token=9fe25332679ebce952fdd9f7f9a83c3e";

        RestTemplate restTemplate = new RestTemplate();

        ClimaClima[] response = restTemplate.getForObject(apiUrl, ClimaClima[].class);

        return Objects.nonNull(response) ? particionarDados(response) : null;
    }
    public ClimaClima particionarDados(ClimaClima[] array){
        ClimaClima clima = new ClimaClima();
        clima.setCountry(array[0].getCountry());
        clima.setText(array[0].getText());
        clima.setDate(array[0].getDate());
        return clima;
    }
    public void deletarClima(ClimaModel clima){
        climaRepository.delete(clima);
    }
    public void salvarClima(){
        ClimaClima climaVO = this.preverTempo();
        ClimaModel climaEntity = this.preparaObjClima(climaVO);
        this.climaRepository.save(climaEntity);
    }
    private ClimaModel preparaObjClima(ClimaClima climaVo){
        ClimaModel clima = new ClimaModel();
        clima.setNome(climaVo.getCountry());
        clima.setText(climaVo.getText());
        clima.setData(clima.getData());
        return  clima;
    }
    public List<ClimaModel> obterTodos(){
        return this.climaRepository.findAll();
    }

}
