package com.example.Fipe.controller;
import com.example.Fipe.model.FipeEntity;
import com.example.Fipe.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/tabelaFipe")
public class Controller {
    @Autowired
    private Service service;
    @GetMapping("/marcas")
    public String searchMarcas(){
        return service.searchMarcas();
    }
    @GetMapping("/modelos/{marca}")
    public String searchModelos(@PathVariable int marca){
        return service.searchModelos(marca);
    }
    @GetMapping("/anos/{marca}/{modelo}")
    public String searchAnos(@PathVariable int marca, @PathVariable int modelo){
        return service.searchAnos(marca, modelo);
    }
    @GetMapping("/valor/{marca}/{modelo}/{ano}")
    public String searchValor(@PathVariable int marca, @PathVariable int modelo, @PathVariable String ano){
        return service.searchValor(marca, modelo, ano);
    }
    @PostMapping("/saveMarcas")
    public void saveMarcas(){
        service.saveMarcas();
    }
    @PutMapping("/updateMarcas")
    public void updateMarcas(@RequestBody FipeEntity marca){
        service.updateMarcas(marca);
    }
    @DeleteMapping("/deleteMarcas")
    public void deleteMarcas(@RequestBody FipeEntity marca){
        service.deleteMarcas(marca);
    }
}

