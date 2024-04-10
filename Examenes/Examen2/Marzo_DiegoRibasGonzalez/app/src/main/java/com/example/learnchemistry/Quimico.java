package com.example.learnchemistry;

public class Quimico {
    private String quimico;
    private int idQuimico;

    public Quimico(String quimico, int idQuimico) {
        this.quimico = quimico;
        this.idQuimico = idQuimico;
    }

    public String getQuimico() {
        return quimico;
    }

    public void setQuimico(String quimico) {
        this.quimico = quimico;
    }

    public int getIdQuimico() {
        return idQuimico;
    }

    public void setIdQuimico(int idQuimico) {
        this.idQuimico = idQuimico;
    }
}
