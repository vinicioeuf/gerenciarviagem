package com.gerebia.gerenciarviagem.service;

import org.springframework.stereotype.Service;
import com.gerebia.gerenciarviagem.observer.ConcreteObserver;
import com.gerebia.gerenciarviagem.observer.Subject;

@Service
public class ViagemService {
    
    private Subject viagemSubject;

    public ViagemService() {
        
        this.viagemSubject = new Subject(); 
    }

    
    public void adicionarPassageiro(String nome) {
        
        ConcreteObserver passageiro = new ConcreteObserver(nome);
        
        viagemSubject.addObserver(passageiro);  
    }

    
    public void alterarStatusViagem(String status) {
       
        viagemSubject.setEstado(status);
    }

    
    public void notificarObservadores(String estado) {
       
        viagemSubject.setEstado(estado);
    }
}
