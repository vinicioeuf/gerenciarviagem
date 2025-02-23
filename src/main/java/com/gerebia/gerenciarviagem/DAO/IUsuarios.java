package com.gerebia.gerenciarviagem.DAO;

import com.gerebia.gerenciarviagem.model.Usuarios;
import org.springframework.data.repository.CrudRepository;

public interface IUsuarios extends CrudRepository<Usuarios, Integer> {
}
