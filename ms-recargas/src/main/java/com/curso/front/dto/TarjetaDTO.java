package com.curso.front.dto;

public class TarjetaDTO {

    // Nombres en snake_case: deben coincidir con los campos expuestos por ms-tarjetas
    private Long id_tarjeta;
    private String nom_titular;
    private Double saldo_asignado;
    private Double saldo_disponible;

    public Long getId_tarjeta() {
        return id_tarjeta;
    }

    public void setId_tarjeta(Long id_tarjeta) {
        this.id_tarjeta = id_tarjeta;
    }

    public String getNom_titular() {
        return nom_titular;
    }

    public void setNom_titular(String nom_titular) {
        this.nom_titular = nom_titular;
    }

    public Double getSaldo_asignado() {
        return saldo_asignado;
    }

    public void setSaldo_asignado(Double saldo_asignado) {
        this.saldo_asignado = saldo_asignado;
    }

    public Double getSaldo_disponible() {
        return saldo_disponible;
    }

    public void setSaldo_disponible(Double saldo_disponible) {
        this.saldo_disponible = saldo_disponible;
    }
}
