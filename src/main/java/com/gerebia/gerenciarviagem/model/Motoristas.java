package com.gerebia.gerenciarviagem.model;

import jakarta.persistence.*;

@Entity
@Table(name = "motorista")
@PrimaryKeyJoinColumn(name = "usuario_id")
public class Motoristas extends Usuarios {

    @Column(name = "cpf", length = 14, nullable = false, unique = true)
    private String cpf;

    @Column(name = "telefone", length = 15, nullable = false)
    private String telefone;

    @Column(name = "cnh", length = 12, nullable = false, unique = true)
    private String cnh;

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCnh() {
        return cnh;
    }

    public void setCnh(String cnh) {
        this.cnh = cnh;
    }
}
