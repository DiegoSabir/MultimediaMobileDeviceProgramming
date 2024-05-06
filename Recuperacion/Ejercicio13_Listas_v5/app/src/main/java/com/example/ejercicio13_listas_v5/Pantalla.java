package com.example.ejercicio13_listas_v5;

public class Pantalla {
    private String opcionFila;
    private String informacionFila;
    private String numerosColoresFila;
    private int imagenPantallaFila;

    public Pantalla(String opcionFila, String informacionFila, String numerosColoresFila, int imagenPantallaFila) {
        this.opcionFila = opcionFila;
        this.informacionFila = informacionFila;
        this.numerosColoresFila = numerosColoresFila;
        this.imagenPantallaFila = imagenPantallaFila;
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

    public int getImagenPantallaFila() {
        return imagenPantallaFila;
    }

    public void setImagenPantallaFila(int imagenPantallaFila) {
        this.imagenPantallaFila = imagenPantallaFila;
    }
}
