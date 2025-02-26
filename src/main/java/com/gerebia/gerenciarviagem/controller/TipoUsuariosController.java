package com.gerebia.gerenciarviagem.controller;

import com.gerebia.gerenciarviagem.DAO.IUsuarios;
import com.gerebia.gerenciarviagem.DAO.ITipoUsuarios;
import com.gerebia.gerenciarviagem.model.Usuarios;
import com.gerebia.gerenciarviagem.model.TipoUsuarios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tipo_usuarios")
public class TipoUsuariosController {

    @Autowired
    private ITipoUsuarios iTipoUsuario;

    @GetMapping
    public List<TipoUsuarios> listarTipoUsuarios() {
        return (List<TipoUsuarios>) iTipoUsuario.findAll();
    }
}
