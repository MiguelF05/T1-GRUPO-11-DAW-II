package com.edu.ms_notificaciones;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;

public class RecargaEvento implements Serializable {

    @JsonProperty("idRecarga")
    private Long idRecarga;

    @JsonProperty("cuentaId")
    private String idTarjeta;

    @JsonProperty("saldo")
    private double saldoDisponible;

    @JsonProperty("monto")
    private double montoRecarga;

    @JsonProperty("fechaActual")
    private String fechaRecarga;

    public RecargaEvento() {}

    public RecargaEvento(Long idRecarga, String idTarjeta, double saldoDisponible, double montoRecarga, String fechaRecarga) {
        this.idRecarga = idRecarga;
        this.idTarjeta = idTarjeta;
        this.saldoDisponible = saldoDisponible;
        this.montoRecarga = montoRecarga;
        this.fechaRecarga = fechaRecarga;
    }

    public Long getIdRecarga() { return idRecarga; }
    public void setIdRecarga(Long idRecarga) { this.idRecarga = idRecarga; }

    public String getIdTarjeta() { return idTarjeta; }
    public void setIdTarjeta(String idTarjeta) { this.idTarjeta = idTarjeta; }

    public double getSaldoDisponible() { return saldoDisponible; }
    public void setSaldoDisponible(double saldoDisponible) { this.saldoDisponible = saldoDisponible; }

    public double getMontoRecarga() { return montoRecarga; }
    public void setMontoRecarga(double montoRecarga) { this.montoRecarga = montoRecarga; }

    public String getFechaRecarga() { return fechaRecarga; }
    public void setFechaRecarga(String fechaRecarga) { this.fechaRecarga = fechaRecarga; }
}