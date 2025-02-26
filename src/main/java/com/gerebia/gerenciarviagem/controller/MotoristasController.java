package com.gerebia.gerenciarviagem.controller;

import com.gerebia.gerenciarviagem.DAO.IMotoristas;
import com.gerebia.gerenciarviagem.DAO.IUsuarios;
import com.gerebia.gerenciarviagem.DAO.ITipoUsuarios;
import com.gerebia.gerenciarviagem.model.Motoristas;
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

    @GetMapping
    public List<Motoristas> listarTipoUsuarios() {
        return (List<Motoristas>) iMotoristas.findAll();
    }
}
