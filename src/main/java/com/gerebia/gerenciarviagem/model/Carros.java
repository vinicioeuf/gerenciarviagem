package com.gerebia.gerenciarviagem.model;

import jakarta.persistence.*;

@Entity
@Table(name = "carro")
public class Carros {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "modelo", length = 50, nullable = false)
    private String modelo;

    @Column(name = "placa", length = 10, nullable = false, unique = true)
    private String placa;

    @Column(name = "ano", nullable = false)
    private int ano;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }
}
