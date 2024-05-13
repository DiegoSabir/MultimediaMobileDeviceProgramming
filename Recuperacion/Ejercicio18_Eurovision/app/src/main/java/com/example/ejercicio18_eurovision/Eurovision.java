package com.example.ejercicio18_eurovision;

public class Eurovision {
    private String pais, interprete, cancion;
    private int votosJurado, votosAudiencia;

    public Eurovision(String pais, String interprete, String cancion, int votosJurado, int votosAudiencia) {
        this.pais = pais;
        this.interprete = interprete;
        this.cancion = cancion;
        this.votosJurado = votosJurado;
        this.votosAudiencia = votosAudiencia;
    }

    public Eurovision(String pais, int votosJurado, int votosAudiencia) {
        this.pais = pais;
        this.votosJurado = votosJurado;
        this.votosAudiencia = votosAudiencia;
    }

    public Eurovision(String pais) {
        this.pais = pais;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getInterprete() {
        return interprete;
    }

    public void setInterprete(String interprete) {
        this.interprete = interprete;
    }

    public String getCancion() {
        return cancion;
    }

    public void setCancion(String cancion) {
        this.cancion = cancion;
    }

    public int getVotosJurado() {
        return votosJurado;
    }

    public void setVotosJurado(int votosJurado) {
        this.votosJurado = votosJurado;
    }

    public int getVotosAudiencia() {
        return votosAudiencia;
    }

    public void setVotosAudiencia(int votosAudiencia) {
        this.votosAudiencia = votosAudiencia;
    }
}