package com.gerebia.gerenciarviagem.controller;

import com.gerebia.gerenciarviagem.DAO.IMotoristas;
import com.gerebia.gerenciarviagem.DAO.IPassageiros;
import com.gerebia.gerenciarviagem.DAO.IUsuarios;
import com.gerebia.gerenciarviagem.DAO.ITipoUsuarios;
import com.gerebia.gerenciarviagem.model.Motoristas;
import com.gerebia.gerenciarviagem.model.Passageiros;
import com.gerebia.gerenciarviagem.model.Usuarios;
import com.gerebia.gerenciarviagem.model.TipoUsuarios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/passageiros")
public class PassageirosController {

    @Autowired
    private IPassageiros ipassageiros;

    @GetMapping
    public List<Passageiros> listarTipoPassageiros() {
        return (List<Passageiros>) ipassageiros.findAll();
    }

    @PostMapping
    public Passageiros cadastrarPass(@RequestBody Passageiros pass) {
        if (pass.getTipo() != null && pass.getTipo().getId() != null) {
            Optional<Passageiros> tipoOptional = ipassageiros.findById(pass.getTipo().getId());
            if (tipoOptional.isPresent()) {
                pass.setTipo(tipoOptional.get().getTipo());
            } else {
                throw new RuntimeException("Tipo de usuário inválido!");
            }
        } else {
            throw new RuntimeException("O tipo de usuário é obrigatório!");
        }

        return ipassageiros.save(pass);
    }
}
