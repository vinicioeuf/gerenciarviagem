package com.gerebia.gerenciarviagem.controller;

import com.gerebia.gerenciarviagem.DAO.IPassagens;
import com.gerebia.gerenciarviagem.model.Carros;
import com.gerebia.gerenciarviagem.model.Passagens;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/passagens")
public class PassagensController {

    @Autowired
    private IPassagens iPassagens;

    @GetMapping
    public List<Passagens> listarTipoUsuarios() {
        return (List<Passagens>) iPassagens.findAll();
    }
    
    @PostMapping
    public Passagens cadastrarCarro(@RequestBody Passagens carro) {
        return iPassagens.save(carro);
    }

   

    @DeleteMapping("/{id}")
    public Optional<Passagens> deletarCarro(@PathVariable Integer id) {
        Optional<Passagens> passagem = iPassagens.findById(id);
        if (passagem.isPresent()) {
            iPassagens.deleteById(id);
        }
        return passagem;
    }
}
