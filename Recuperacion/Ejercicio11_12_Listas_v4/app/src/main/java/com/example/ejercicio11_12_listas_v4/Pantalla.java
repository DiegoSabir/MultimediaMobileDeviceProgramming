package com.example.ejercicio11_12_listas_v4;

public class Pantalla {
    private String opcionFila;
    private String informacionFila;
    private String numerosColoresFila;

    public Pantalla(String opcionFila, String informacionFila, String numerosColoresFila) {
        this.opcionFila = opcionFila;
        this.informacionFila = informacionFila;
        this.numerosColoresFila = numerosColoresFila;
    }

    public String getOpcionFila() {
        return opcionFila;
    }

    public void setOpcionFila(String opcionFila) {
        this.opcionFila = opcionFila;
    }

    public String getInformacionFila() {
        return informacionFila;
    }

    public void setInformacionFila(String informacionFila) {
        this.informacionFila = informacionFila;
    }

    public String getNumerosColoresFila() {
        return numerosColoresFila;
    }

    public void setNumerosColoresFila(String numerosColoresFila) {
        this.numerosColoresFila = numerosColoresFila;
    }
}
