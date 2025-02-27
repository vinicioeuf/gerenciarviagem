package com.gerebia.gerenciarviagem.model;

import jakarta.persistence.*;

@Entity
@Table(name = "passagem")
public class Passagens {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "passageiro_id", nullable = false)
    private Passageiros passageiro;

    @ManyToOne
    @JoinColumn(name = "viagem_id", nullable = false)
    private Viagens viagem;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Passageiros getPassageiro() {
        return passageiro;
    }

    public void setPassageiro(Passageiros passageiro) {
        this.passageiro = passageiro;
    }

    public Viagens getViagem() {
        return viagem;
    }

    public void setViagem(Viagens viagem) {
        this.viagem = viagem;
    }
}
