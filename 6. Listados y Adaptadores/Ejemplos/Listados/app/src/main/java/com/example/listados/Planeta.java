package com.example.listados;

public class Planeta {

    private String nombrePlaneta;
    private int idFotoPlaneta;

    public Planeta(String nombrePlaneta, int idFotoPlaneta) {
        this.nombrePlaneta = nombrePlaneta;
        this.idFotoPlaneta = idFotoPlaneta;
    }

    public String getNombrePlaneta() {
        return nombrePlaneta;
    }

    public void setNombrePlaneta(String nombrePlaneta) {
        this.nombrePlaneta = nombrePlaneta;
    }

    public int getIdFotoPlaneta() {
        return idFotoPlaneta;
    }

    public void setIdFotoPlaneta(int idFotoPlaneta) {
        this.idFotoPlaneta = idFotoPlaneta;
    }
}
