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
@RequestMapping("/usuarios")
public class UsuariosController {

    @Autowired
    private IUsuarios iusuarios;

    @Autowired
    private ITipoUsuarios iTipoUsuario; // Adicionando DAO para TipoUsuario

    @GetMapping
    public List<Usuarios> listarUsuarios() {
        return (List<Usuarios>) iusuarios.findAll();
    }

    @PostMapping
    public Usuarios cadastrarUsuario(@RequestBody Usuarios usuario) {
        if (usuario.getTipo() != null && usuario.getTipo().getId() != null) {
            Optional<TipoUsuarios> tipoOptional = iTipoUsuario.findById(usuario.getTipo().getId());
            if (tipoOptional.isPresent()) {
                usuario.setTipo(tipoOptional.get());
            } else {
                throw new RuntimeException("Tipo de usuário inválido!");
            }
        } else {
            throw new RuntimeException("O tipo de usuário é obrigatório!");
        }

        return iusuarios.save(usuario);
    }

    @PutMapping
    public Usuarios atualizarUsuario(@RequestBody Usuarios usuario) {
        if (usuario.getTipo() != null && usuario.getTipo().getId() != null) {
            Optional<TipoUsuarios> tipoOptional = iTipoUsuario.findById(usuario.getTipo().getId());
            if (tipoOptional.isPresent()) {
                usuario.setTipo(tipoOptional.get());
            } else {
                throw new RuntimeException("Tipo de usuário inválido!");
            }
        } else {
            throw new RuntimeException("O tipo de usuário é obrigatório!");
        }

        return iusuarios.save(usuario);
    }

    @DeleteMapping("/{id}")
    public Optional<Usuarios> deletarUsuario(@PathVariable int id) {
        Optional<Usuarios> usuario = iusuarios.findById(id);
        if (usuario.isPresent()) {
            iusuarios.deleteById(id);
        }
        return usuario;
    }
}
