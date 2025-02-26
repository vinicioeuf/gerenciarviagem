package com.gerebia.gerenciarviagem.DAO;
import com.gerebia.gerenciarviagem.model.TipoUsuarios;
import org.springframework.data.repository.CrudRepository;

public interface ITipoUsuarios extends CrudRepository<TipoUsuarios, Integer> {
}