package com.gerebia.gerenciarviagem.DAO;

import com.gerebia.gerenciarviagem.model.Viagens;
import org.springframework.data.repository.CrudRepository;

public interface IViagens extends CrudRepository<Viagens, Integer> {
}
