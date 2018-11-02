package com.miedosoft.interactive.model;

public class PeticionRequest {

    private String nroCuenta;

    private String password;

    private Double cantidad;

    public PeticionRequest(String nroCuenta, String password, Double cantidad) {
        this.nroCuenta = nroCuenta;
        this.password = password;
        this.cantidad = cantidad;
    }

    public PeticionRequest() {

    }

    public String getNroCuenta() {
        return nroCuenta;
    }

    public void setNroCuenta(String nroCuenta) {
        this.nroCuenta = nroCuenta;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Double getCantidad() {
        return cantidad;
    }

    public void setCantidad(Double cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return "PeticionRequest{" +
                "nroCuenta='" + nroCuenta + '\'' +
                ", password='" + password + '\'' +
                ", cantidad=" + cantidad +
                '}';
    }
}
