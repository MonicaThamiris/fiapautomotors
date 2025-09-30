package br.com.fiap.fiapautomotors.adapters.out.persistence.repository;

import br.com.fiap.fiapautomotors.adapters.out.persistence.entities.VeiculoEntity;
import br.com.fiap.fiapautomotors.core.enums.StatusVeiculo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VeiculoRepositoryJPA extends JpaRepository<VeiculoEntity, String> {

    List<VeiculoEntity> findByStatusOrderByPrecoAsc(StatusVeiculo status);
}
