package com.udesc.common.model;

import java.util.ArrayList;

public class Familia {
    private String sobrenome;
    private String descendencia;
    private double renda;
    private ArrayList<Pessoa> integrantes;

    public Familia(String sobrenome, String descendencia, double renda) {
        this.sobrenome = sobrenome;
        this.descendencia = descendencia;
        this.renda = renda;
        this.integrantes = new ArrayList<>();
    }

    public String getSobrenome() {
        return this.sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getDescendencia() {
        return this.descendencia;
    }

    public void setDescendencia(String descendencia) {
        this.descendencia = descendencia;
    }

    public double getRenda() {
        return this.renda;
    }

    public void setRenda(double renda) {
        this.renda = renda;
    }

    public ArrayList<Pessoa> getIntegrantes() {
        return this.integrantes;
    }

    @Override
    public boolean equals(Object obj) {
        return getSobrenome().equals(((Familia) obj).getSobrenome());
    }

    @Override
    public String toString() {
        String result = String.format("%s;%s;%.2f", getSobrenome(), getDescendencia(), getRenda());
        result += "\n" + String.valueOf(integrantes.size());
        for (Pessoa integrante : integrantes) {
            result += "\n" + integrante.toString();
        }
        return result;
    }
}