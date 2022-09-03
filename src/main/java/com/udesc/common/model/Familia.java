package com.udesc.common.model;

import java.util.ArrayList;
import java.util.List;

public class Familia {
    private String sobrenome;
    private String descendencia;
    private String renda;
    private List<Pessoa> integrantes;

    public Familia(String sobrenome, String descendencia, String renda) {
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

    public String getRenda() {
        return this.renda;
    }

    public void setRenda(String renda) {
        this.renda = renda;
    }

    public List<Pessoa> getIntegrantes() {
        return integrantes;
    }
    
    public void addIntegrante(Pessoa pessoa) {
        integrantes.add(pessoa);
    }

    @Override
    public String toString() {
        String result = String.format("%s, %s, %d\n", getSobrenome(), getDescendencia(), getRenda());
        for (Pessoa integrante : integrantes) {
            result += integrante.toString();
        }
        return result;
    }
}