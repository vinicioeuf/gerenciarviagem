package com.gerebia.gerenciarviagem.DAO;

import com.gerebia.gerenciarviagem.model.Carros;
import org.springframework.data.repository.CrudRepository;

public interface ICarros extends CrudRepository<Carros, Integer> {
}
