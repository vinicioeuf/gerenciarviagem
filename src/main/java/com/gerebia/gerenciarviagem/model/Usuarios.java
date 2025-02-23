package com.gerebia.gerenciarviagem.model;

import jakarta.persistence.*;

@Entity
@Table(name="usuarios")
public class Usuarios {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "nome", length = 220, nullable = true)
    private String nome;

    @Column(name = "email", length = 220, nullable = true)
    private String email;

    @Column(name = "senha", columnDefinition = "TEXT", nullable = true)
    private String senha;

    @Column(name = "tipo", length = 3, nullable = true)
    private Integer tipo;

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

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
}
