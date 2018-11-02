package com.miedosoft.interactive.model;

public class PeticionReply {

    private String nombrePropietario;

    private Double saldoModificado;

    private Double saldoActual;

    public PeticionReply(String nombrePropietario, Double saldoModificado, Double saldoActual) {
        this.nombrePropietario = nombrePropietario;
        this.saldoModificado = saldoModificado;
        this.saldoActual = saldoActual;
    }

    public PeticionReply() {
    }

    public String getNombrePropietario() {
        return nombrePropietario;
    }

    public void setNombrePropietario(String nombrePropietario) {
        this.nombrePropietario = nombrePropietario;
    }

    public Double getSaldoActual() {
        return saldoActual;
    }

    public void setSaldoActual(Double saldoActual) {
        this.saldoActual = saldoActual;
    }

    public Double getSaldoModificado() {
        return saldoModificado;
    }

    public void setSaldoModificado(Double saldoModificado) {
        this.saldoModificado = saldoModificado;
    }

    @Override
    public String toString() {
        return "PeticionReply{" +
                "nombrePropietario='" + nombrePropietario + '\'' +
                ", saldoModificado=" + saldoModificado +
                ", saldoActual=" + saldoActual +
                '}';
    }
}
