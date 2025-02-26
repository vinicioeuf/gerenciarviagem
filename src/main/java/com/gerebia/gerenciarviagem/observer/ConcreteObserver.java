package com.gerebia.gerenciarviagem.observer;

public class ConcreteObserver implements Observer {
    private String nome;

    public ConcreteObserver(String nome) {
        this.nome = nome;
    }

    
    public void update(String mensagem) {
        System.out.println("Observador " + nome + " recebeu a mensagem: " + mensagem);
    }
}