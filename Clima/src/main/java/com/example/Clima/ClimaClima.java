package com.example.Clima;
public class ClimaClima {
    private String country;
    private  String text;
    private String date;
    public ClimaClima(String country, String text, String date) {
        this.country = country;
        this.text = text;
        this.date = date;
    }
    public ClimaClima() {
    }
    public String getCountry() {
        return country;
    }
    public void setCountry(String country) {
        this.country = country;
    }
    public String getText() {
        return text;
    }
    public void setText(String text) {
        this.text = text;
    }
    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }
}
