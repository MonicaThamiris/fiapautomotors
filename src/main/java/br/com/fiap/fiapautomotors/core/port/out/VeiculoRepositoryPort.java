package br.com.fiap.fiapautomotors.core.port.out;

import br.com.fiap.fiapautomotors.core.domain.Cliente;
import br.com.fiap.fiapautomotors.core.domain.Veiculo;
import br.com.fiap.fiapautomotors.core.enums.StatusVeiculo;

import java.util.List;
import java.util.Optional;

public interface VeiculoRepositoryPort {

    Veiculo salvar(Veiculo veiculo);

    Optional<Veiculo> buscarPorId(String id);

    List<Veiculo> consultarPorStatus(StatusVeiculo status);

    List<Veiculo> consultarTodos();

    Veiculo registrarCompra(Cliente cliente, Veiculo veiculo);
}
