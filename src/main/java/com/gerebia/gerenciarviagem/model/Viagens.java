package com.gerebia.gerenciarviagem.model;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "viagem")
public class Viagens {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "origem", length = 100, nullable = false)
    private String origem;

    @Column(name = "destino", length = 100, nullable = false)
    private String destino;

    @Column(name = "valor_passagem", nullable = false)
    private BigDecimal valorPassagem;

    @ManyToOne
    @JoinColumn(name = "motorista_id", nullable = false)
    private Motoristas motorista;

    @ManyToOne
    @JoinColumn(name = "carro_id", nullable = false)
    private Carros carro;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrigem() {
        return origem;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public BigDecimal getValorPassagem() {
        return valorPassagem;
    }

    public void setValorPassagem(BigDecimal valorPassagem) {
        this.valorPassagem = valorPassagem;
    }

    public Motoristas getMotorista() {
        return motorista;
    }

    public void setMotorista(Motoristas motorista) {
        this.motorista = motorista;
    }

    public Carros getCarro() {
        return carro;
    }

    public void setCarro(Carros carro) {
        this.carro = carro;
    }
}
