package com.miedosoft.interactive.model;

public class ConsultaBancoReply {

    /**
     * {
     * "cuentaEncontrada": true,
     * "saldoModificado": 8000,
     * "saldoActual": 13600,
     * "nombrePropietario": "Billy"
     * }
     */

    private Boolean cuentaEncontrada;
    private Double saldoModificado;
    private Double saldoActual;
    private String nombrePropietario;

    public ConsultaBancoReply() {
    }

    public Boolean getCuentaEncontrada() {
        return cuentaEncontrada;
    }

    public void setCuentaEncontrada(Boolean cuentaEncontrada) {
        this.cuentaEncontrada = cuentaEncontrada;
    }

    public Double getSaldoModificado() {
        return saldoModificado;
    }

    public void setSaldoModificado(Double saldoModificado) {
        this.saldoModificado = saldoModificado;
    }

    public Double getSaldoActual() {
        return saldoActual;
    }

    public void setSaldoActual(Double saldoActual) {
        this.saldoActual = saldoActual;
    }

    public String getNombrePropietario() {
        return nombrePropietario;
    }

    public void setNombrePropietario(String nombrePropietario) {
        this.nombrePropietario = nombrePropietario;
    }


}
