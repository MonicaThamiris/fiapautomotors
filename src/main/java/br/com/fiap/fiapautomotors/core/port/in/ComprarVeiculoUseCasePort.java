package br.com.fiap.fiapautomotors.core.port.in;

import br.com.fiap.fiapautomotors.core.domain.Veiculo;

public interface ComprarVeiculoUseCasePort {

    Veiculo comprar(String idCliente, String id);
}
