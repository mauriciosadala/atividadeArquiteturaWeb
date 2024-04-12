package com.example.Fipe.model;

public class Fipee {
    private String codigo, nome;
    public Fipee(String codigo, String nome) {
        this.codigo = codigo;
        this.nome = nome;
    }
    public Fipee() {
    }
    public String getCodigo() {
        return codigo;
    }
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
}
