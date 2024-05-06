package com.example.ejercicio13_listas_v5;

public class Padding {
    private String opcionPaddingFila;
    private int imagenPaddingFila;

    public Padding(String opcionPaddingFila, int imagenPaddingFila) {
        this.opcionPaddingFila = opcionPaddingFila;
        this.imagenPaddingFila = imagenPaddingFila;
    }

    public String getOpcionPaddingFila() {
        return opcionPaddingFila;
    }

    public void setOpcionPaddingFila(String opcionPaddingFila) {
        this.opcionPaddingFila = opcionPaddingFila;
    }

    public int getImagenPaddingFila() {
        return imagenPaddingFila;
    }

    public void setImagenPaddingFila(int imagenPaddingFila) {
        this.imagenPaddingFila = imagenPaddingFila;
    }
}
