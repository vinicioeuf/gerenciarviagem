package com.gerebia.gerenciarviagem.controller;

import com.gerebia.gerenciarviagem.DAO.ICarros;
import com.gerebia.gerenciarviagem.model.Carros;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/carros")
public class CarrosController {

    @Autowired
    private ICarros iCarros;

    @GetMapping
    public List<Carros> listarCarros() {
        return (List<Carros>) iCarros.findAll();
    }
    
    @PostMapping
    public Carros cadastrarCarro(@RequestBody Carros carro) {
        return iCarros.save(carro);
    }

    @PutMapping
    public Carros atualizarCarro(@RequestBody Carros carro) {
        if (carro.getId() == null) {
            throw new RuntimeException("O ID do carro é obrigatório para atualização!");
        }
        return iCarros.save(carro);
    }

    @DeleteMapping("/{id}")
    public Optional<Carros> deletarCarro(@PathVariable Integer id) {
        Optional<Carros> carro = iCarros.findById(id);
        if (carro.isPresent()) {
            iCarros.deleteById(id);
        }
        return carro;
    }
}
