package com.gerebia.gerenciarviagem.model;

import jakarta.persistence.*;

@Entity
@Table(name = "passagem")
public class Passagens {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuarios passageiro;

    @ManyToOne
    @JoinColumn(name = "viagem_id", nullable = false)
    private Viagens viagem;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Usuarios getPassageiro() {
        return passageiro;
    }

    public void setPassageiro(Usuarios passageiro) {
        if (passageiro.getPassageiro() != null && passageiro.getPassageiro() == 1) {
            this.passageiro = passageiro;
        } else {
            throw new IllegalArgumentException("O usuário deve ser um passageiro.");
        }
    }

    public Viagens getViagem() {
        return viagem;
    }

    public void setViagem(Viagens viagem) {
        this.viagem = viagem;
    }
}
