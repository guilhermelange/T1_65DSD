package com.udesc.common.model;

public class Familia {
    private String sobrenome;
    private String descendencia;
    private String renda;


    public Familia(String sobrenome, String descendencia, String renda) {
        this.sobrenome = sobrenome;
        this.descendencia = descendencia;
        this.renda = renda;
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

    @Override
    public String toString() {
        return "{" +
            " sobrenome='" + getSobrenome() + "'" +
            ", descendencia='" + getDescendencia() + "'" +
            ", renda='" + getRenda() + "'" +
            "}";
    }
}