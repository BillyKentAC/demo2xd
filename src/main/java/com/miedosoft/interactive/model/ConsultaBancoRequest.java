package com.miedosoft.interactive.model;

import java.io.Serializable;

public class ConsultaBancoRequest implements Serializable {
    private String nroCuenta;

    private String cvv;

    private Double cantidad;

    public ConsultaBancoRequest(String nroCuenta, String cvv, Double cantidad) {
        this.nroCuenta = nroCuenta;
        this.cvv = cvv;
        this.cantidad = cantidad;
    }

    public ConsultaBancoRequest() {

    }

    public String getNroCuenta() {
        return nroCuenta;
    }

    public void setNroCuenta(String nroCuenta) {
        this.nroCuenta = nroCuenta;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public Double getCantidad() {
        return cantidad;
    }

    public void setCantidad(Double cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return "ConsultaBancoRequest{" +
                "nroCuenta='" + nroCuenta + '\'' +
                ", cvv='" + cvv + '\'' +
                ", cantidad=" + cantidad +
                '}';
    }
}
