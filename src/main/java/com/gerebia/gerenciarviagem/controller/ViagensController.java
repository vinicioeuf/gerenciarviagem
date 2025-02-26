package com.gerebia.gerenciarviagem.controller;

import com.gerebia.gerenciarviagem.DAO.IViagens;

import com.gerebia.gerenciarviagem.model.Viagens;

import service.ViagemService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/viagens")
public class ViagensController {

    @Autowired
    private IViagens iViagens;
    @Autowired
    private ViagemService viagemService; 

    @GetMapping
    public List<Viagens> listarTipoUsuarios() {
        return (List<Viagens>) iViagens.findAll();
    }
    
    @PostMapping
    public Viagens cadastrarViagem(@RequestBody Viagens viagem) {
    	viagemService.notificarObservadores("Viagem de " + viagem.getOrigem() + " para " + viagem.getDestino());  
        return iViagens.save(viagem);
    }

    @PutMapping
    public Viagens atualizarViagem(@RequestBody Viagens viagem) {
        if (viagem.getId() == null) {
            throw new RuntimeException("O ID do carro é obrigatório para atualização!");
        }
        return iViagens.save(viagem);
    }

    @DeleteMapping("/{id}")
    public Optional<Viagens> deletarViagem(@PathVariable Integer id) {
        Optional<Viagens> viagem = iViagens.findById(id);
        if (viagem.isPresent()) {
            iViagens.deleteById(id);
        }
        return viagem;
    }
}
