package br.com.fiap.fiapautomotors.core.port.in;

import br.com.fiap.fiapautomotors.core.domain.Veiculo;
import br.com.fiap.fiapautomotors.core.enums.StatusVeiculo;

import java.util.List;

public interface ConsultarVeiculosUseCasePort {
    List<Veiculo> consultar(StatusVeiculo status);
}
