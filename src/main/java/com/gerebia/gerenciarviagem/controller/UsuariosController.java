package com.gerebia.gerenciarviagem.controller;

import com.gerebia.gerenciarviagem.DAO.IUsuarios;
import com.gerebia.gerenciarviagem.model.Usuarios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/usuarios")
public class UsuariosController {

    @Autowired
    private IUsuarios usuarioRepository;

    @GetMapping
    public Iterable<Usuarios> listarUsuarios() {
        return usuarioRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuarios> buscarUsuario(@PathVariable Integer id) {
        Optional<Usuarios> usuario = usuarioRepository.findById(id);
        return usuario.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Usuarios criarUsuario(@RequestBody Usuarios usuario) {
        return usuarioRepository.save(usuario);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Usuarios> atualizarUsuario(@PathVariable Integer id, @RequestBody Usuarios usuarioAtualizado) {
        return usuarioRepository.findById(id)
                .map(usuario -> {
                    usuario.setNome(usuarioAtualizado.getNome());
                    usuario.setEmail(usuarioAtualizado.getEmail());
                    usuario.setSenha(usuarioAtualizado.getSenha());
                    usuario.setPassageiro(usuarioAtualizado.getPassageiro());
                    usuario.setMotorista(usuarioAtualizado.getMotorista());
                    Usuarios atualizado = usuarioRepository.save(usuario);
                    return ResponseEntity.ok(atualizado);
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarUsuario(@PathVariable Integer id) {
        if (usuarioRepository.existsById(id)) {
            usuarioRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}