package com.gerebia.gerenciarviagem.DAO;

import com.gerebia.gerenciarviagem.model.Passagens;
import org.springframework.data.repository.CrudRepository;

public interface IPassagens extends CrudRepository<Passagens, Integer> {
}
