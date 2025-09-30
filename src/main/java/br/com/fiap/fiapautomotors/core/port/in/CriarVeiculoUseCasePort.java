package br.com.fiap.fiapautomotors.core.port.in;

import br.com.fiap.fiapautomotors.core.domain.Veiculo;

import java.util.List;

public interface CriarVeiculoUseCasePort {

    Veiculo criar(Veiculo veiculo);
}
