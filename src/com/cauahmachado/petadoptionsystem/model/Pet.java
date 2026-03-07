package com.cauahmachado.petadoptionsystem.model;

public class Pet {
    private String nome;
    private String sobrenome;
    private TipoTipo tipo;
    private TipoSexo sexo;
    private double idadeAproximada;
    private double pesoAproximado;
    private String raca;




    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public TipoTipo getTipo() {
        return tipo;
    }

    public void setTipo(TipoTipo tipo) {
        this.tipo = tipo;
    }

    public TipoSexo getSexo() {
        return sexo;
    }

    public void setSexo(TipoSexo sexo) {
        this.sexo = sexo;
    }

    public double getIdadeAproximada() {
        return idadeAproximada;
    }

    public void setIdadeAproximada(double idadeAproximada) {
        this.idadeAproximada = idadeAproximada;
    }

    public double getPesoAproximado() {
        return pesoAproximado;
    }

    public void setPesoAproximado(double pesoAproximado) {
        this.pesoAproximado = pesoAproximado;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }
}
