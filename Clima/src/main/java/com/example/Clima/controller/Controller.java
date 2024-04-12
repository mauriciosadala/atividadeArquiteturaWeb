package com.example.Clima.controller;
import com.example.Clima.ClimaClima;
import com.example.Clima.model.ClimaModel;
import com.example.Clima.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/clima")
public class Controller {
    @Autowired
    private Service service;
    @PostMapping("/salvar")
    public void salvarClima(){
        service.salvarClima();
    }
    @PutMapping("/atualizarClima")
    public void autalizarClima(@RequestBody ClimaModel clima) {
        service.salvarClima();
    }
    @DeleteMapping
    public void deletarClima(@RequestBody ClimaModel clima){
        service.deletarClima(clima);
    }
    @GetMapping("/obterTodos")
    public List<ClimaModel> obterTodos(){
        return service.obterTodos();
    }
    @GetMapping("/preverTempo")
    public ClimaClima preverTempo(){
        return service.preverTempo();
    }

}
