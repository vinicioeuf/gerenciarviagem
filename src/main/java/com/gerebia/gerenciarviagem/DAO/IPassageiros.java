package com.gerebia.gerenciarviagem.DAO;

import com.gerebia.gerenciarviagem.model.Passageiros;
import org.springframework.data.repository.CrudRepository;

public interface IPassageiros extends CrudRepository<Passageiros, Integer> {
}
