package com.gerebia.gerenciarviagem.controller;

import com.gerebia.gerenciarviagem.DAO.IUsuarios;
import com.gerebia.gerenciarviagem.DAO.ITipoUsuarios;
import com.gerebia.gerenciarviagem.model.Usuarios;
import com.gerebia.gerenciarviagem.model.Motoristas;
import com.gerebia.gerenciarviagem.model.Passageiros;
import com.gerebia.gerenciarviagem.model.TipoUsuarios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuarios")
public class UsuariosController {

    @Autowired
    private IUsuarios iusuarios;

    @Autowired
    private ITipoUsuarios iTipoUsuario; 

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


    @PutMapping("/{id}")
    public ResponseEntity<Usuarios> atualizarUsuario(@PathVariable Integer id, @RequestBody Usuarios usuario) {
        Optional<Usuarios> usuarioExistente = iusuarios.findById(id);

        if (!usuarioExistente.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        Usuarios usuarioAtualizado = usuarioExistente.get();
        
        
        usuarioAtualizado.setNome(usuario.getNome());
        usuarioAtualizado.setEmail(usuario.getEmail());

        
        if (usuario.getTipo() != null && usuario.getTipo().getId() != null) {
            Optional<TipoUsuarios> tipoOptional = iTipoUsuario.findById(usuario.getTipo().getId());
            if (tipoOptional.isPresent()) {
                usuarioAtualizado.setTipo(tipoOptional.get());
            } else {
                return ResponseEntity.badRequest().body(null);
            }
        } else {
            return ResponseEntity.badRequest().body(null);
        }

        Usuarios usuarioSalvo = iusuarios.save(usuarioAtualizado);
        return ResponseEntity.ok(usuarioSalvo);
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
