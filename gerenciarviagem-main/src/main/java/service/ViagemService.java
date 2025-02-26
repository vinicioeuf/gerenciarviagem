package service;

import org.springframework.stereotype.Service;
import observer.ConcreteObserver;
import observer.Subject;

@Service
public class ViagemService {
    
    private Subject viagemSubject;

    public ViagemService() {
        // Inicializa o Subject que gerencia os Observers
        this.viagemSubject = new Subject(); 
    }

    // Método para adicionar um passageiro como observer
    public void adicionarPassageiro(String nome) {
        // Criando um novo observer (passageiro)
        ConcreteObserver passageiro = new ConcreteObserver(nome);
        // Adicionando o passageiro à lista de observers
        viagemSubject.addObserver(passageiro);  
    }

    // Método para alterar o status da viagem
    public void alterarStatusViagem(String status) {
        // Quando o status da viagem mudar, ele notifica todos os observers
        viagemSubject.setEstado(status);
    }

    // Método para notificar os observers após a criação ou alteração da viagem
    public void notificarObservadores(String estado) {
        // Define o novo estado e notifica todos os observers
        viagemSubject.setEstado(estado);
    }
}
