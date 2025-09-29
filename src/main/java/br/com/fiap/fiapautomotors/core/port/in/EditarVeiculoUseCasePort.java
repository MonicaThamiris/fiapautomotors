package br.com.fiap.fiapautomotors.core.port.in;

import br.com.fiap.fiapautomotors.core.domain.Veiculo;

public interface EditarVeiculoUseCasePort {

    Veiculo editar(String id, Veiculo veiculo);
}
