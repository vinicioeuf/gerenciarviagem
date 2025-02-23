package com.gerebia.gerenciarviagem.controller;

import com.gerebia.gerenciarviagem.DAO.IUsuarios;
import com.gerebia.gerenciarviagem.model.Usuarios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuarios")
public class UsuariosController{

    @Autowired
    private IUsuarios iusuarios;

    @GetMapping
    public List<Usuarios> listarUsuarios(){
        return (List<Usuarios>) iusuarios.findAll();
    }

    @PostMapping
    public Usuarios cadastrarUsuario(@RequestBody Usuarios usuario){
        Usuarios usuarioNovo = iusuarios.save(usuario);
        return usuarioNovo;
    }
    @PutMapping
    public Usuarios atualizarUsuario(@RequestBody Usuarios usuario){
        Usuarios usuarioNovo = iusuarios.save(usuario);
        return usuarioNovo;
    }
    @DeleteMapping("/{id}")
    public Optional<Usuarios> deletarUsuario(@PathVariable int id){
        Optional<Usuarios> usuario = iusuarios.findById(id);
        iusuarios.deleteById(id);
        return usuario;
    }




}
