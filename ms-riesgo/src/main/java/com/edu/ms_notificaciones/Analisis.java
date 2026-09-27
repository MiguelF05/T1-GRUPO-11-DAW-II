package com.edu.ms_notificaciones;

import jakarta.persistence.*;

@Entity
@Table(name = "analisis")
public class Analisis {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long idRecarga;
    private String idTarjeta;
    private double saldoDisponible;
    private double montoRecarga;
    private String fechaRecarga;
    private String situacion;

    public Analisis() {}

    public Analisis(Long idRecarga, String idTarjeta, double saldoDisponible, double montoRecarga, String fechaRecarga, String situacion) {
        this.idRecarga = idRecarga;
        this.idTarjeta = idTarjeta;
        this.saldoDisponible = saldoDisponible;
        this.montoRecarga = montoRecarga;
        this.fechaRecarga = fechaRecarga;
        this.situacion = situacion;
    }

    public Long getId() { return id; }
    public Long getIdRecarga() { return idRecarga; }
    public String getIdTarjeta() { return idTarjeta; }
    public double getSaldoDisponible() { return saldoDisponible; }
    public double getMontoRecarga() { return montoRecarga; }
    public String getFechaRecarga() { return fechaRecarga; }
    public String getSituacion() { return situacion; }
}