package com.gerebia.gerenciarviagem.controller;

import com.gerebia.gerenciarviagem.DAO.IMotoristas;
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
@RequestMapping("/motoristas")
public class MotoristasController {

    @Autowired
    private IMotoristas iMotoristas;
    @Autowired
    private ITipoUsuarios iTipoUsuario;
    @GetMapping
    public List<Motoristas> listarTipoUsuarios() {
        return (List<Motoristas>) iMotoristas.findAll();
    }
    
    @PostMapping
    public Motoristas cadastrarMoto(@RequestBody Motoristas motorista) {
        // Verificar se o tipo de usuário foi passado corretamente
        if (motorista.getTipo() != null && motorista.getTipo().getId() != null) {
            // Procurar pelo tipo de usuário no banco
            Optional<TipoUsuarios> tipoOptional = iTipoUsuario.findById(motorista.getTipo().getId());
            if (tipoOptional.isPresent()) {
                // Se o tipo de usuário existir, associá-lo ao passageiro
                motorista.setTipo(tipoOptional.get());
            } else {
                throw new RuntimeException("Tipo de usuário inválido!");
            }
        } else {
            throw new RuntimeException("O tipo de usuário é obrigatório!");
        }

        // Salvar o passageiro com o tipo de usuário associado
        return iMotoristas.save(motorista);
    }
}
