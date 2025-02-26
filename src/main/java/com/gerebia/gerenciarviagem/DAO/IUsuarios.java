package com.gerebia.gerenciarviagem.DAO;

import com.gerebia.gerenciarviagem.model.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUsuarios extends JpaRepository<Usuarios, Integer> {
}
