package com.example.Clima.model;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.Date;
@Document(collection = "clima")
public class ClimaModel {
    @Id
    private String id, pais, text;
    private Date data;

    public ClimaModel(String id, String pais, Date data, String text) {
        this.id = id;
        this.pais = pais;
        this.data = data;
        this.text = text;
    }
    public ClimaModel() {
    }
    // Getters e Setters
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getNome() {
        return pais;
    }
    public void setNome(String nome) {
        this.pais = pais;
    }
    public Date getData() {
        return data;
    }
    public void setData(Date data) {
        this.data = data;
    }
    public String getText() {
        return text;
    }
    public void setText(String text) {
        this.text = text;
    }
}
