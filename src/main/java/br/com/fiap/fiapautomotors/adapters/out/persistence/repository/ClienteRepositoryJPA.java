package br.com.fiap.fiapautomotors.adapters.out.persistence.repository;

import br.com.fiap.fiapautomotors.adapters.out.persistence.entities.ClienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepositoryJPA extends JpaRepository<ClienteEntity, String> {
}
