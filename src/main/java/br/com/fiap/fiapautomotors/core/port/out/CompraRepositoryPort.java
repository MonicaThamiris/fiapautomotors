package br.com.fiap.fiapautomotors.core.port.out;

import br.com.fiap.fiapautomotors.core.domain.Cliente;
import br.com.fiap.fiapautomotors.core.domain.Compra;
import br.com.fiap.fiapautomotors.core.domain.Veiculo;
import br.com.fiap.fiapautomotors.core.enums.StatusVeiculo;

import java.util.List;
import java.util.Optional;

public interface CompraRepositoryPort {
    Optional<Compra> consultarPorId(String id);
}
