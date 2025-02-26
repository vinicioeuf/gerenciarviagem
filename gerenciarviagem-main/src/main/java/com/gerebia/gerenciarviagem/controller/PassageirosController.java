package com.gerebia.gerenciarviagem.controller;


import com.gerebia.gerenciarviagem.DAO.IPassageiros;
import com.gerebia.gerenciarviagem.DAO.ITipoUsuarios;
import com.gerebia.gerenciarviagem.model.Passageiros;
import com.gerebia.gerenciarviagem.model.TipoUsuarios;
import com.gerebia.gerenciarviagem.model.Usuarios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/passageiros")
public class PassageirosController {

    @Autowired
    private IPassageiros ipassageiros;
    @Autowired
    private ITipoUsuarios iTipoUsuario;
    @GetMapping
    public List<Passageiros> listarTipoPassageiros() {
        return (List<Passageiros>) ipassageiros.findAll();
    }

    @PostMapping
    public Passageiros cadastrarPass(@RequestBody Passageiros passageiro) {
        // Verificar se o tipo de usuário foi passado corretamente
        if (passageiro.getTipo() != null && passageiro.getTipo().getId() != null) {
            // Procurar pelo tipo de usuário no banco
            Optional<TipoUsuarios> tipoOptional = iTipoUsuario.findById(passageiro.getTipo().getId());
            if (tipoOptional.isPresent()) {
                // Se o tipo de usuário existir, associá-lo ao passageiro
                passageiro.setTipo(tipoOptional.get());
            } else {
                throw new RuntimeException("Tipo de usuário inválido!");
            }
        } else {
            throw new RuntimeException("O tipo de usuário é obrigatório!");
        }

        // Salvar o passageiro com o tipo de usuário associado
        return ipassageiros.save(passageiro);
    }


}
