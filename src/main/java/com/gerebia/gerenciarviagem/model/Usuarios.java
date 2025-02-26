package com.gerebia.gerenciarviagem.model;

import jakarta.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED) // Estratégia de herança JOINED
@Table(name = "usuarios")
public class Usuarios {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "nome", length = 220, nullable = false)
    private String nome;

    @Column(name = "email", length = 220, nullable = false, unique = true)
    private String email;

    @Column(name = "senha", columnDefinition = "TEXT", nullable = false)
    private String senha;

    @Column(name = "passageiro", nullable = false)
    private Integer passageiro; // 0 = false, 1 = true

    @Column(name = "motorista", nullable = false)
    private Integer motorista; // 0 = false, 1 = true


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Integer getPassageiro() {
        return passageiro;
    }

    public void setPassageiro(Integer passageiro) {
        this.passageiro = passageiro;
    }

    public Integer getMotorista() {
        return motorista;
    }

    public void setMotorista(Integer motorista) {
        this.motorista = motorista;
    }

}
