package br.com.fiap.fiapautomotors.core.usecase;

import br.com.fiap.fiapautomotors.core.domain.Veiculo;
import br.com.fiap.fiapautomotors.core.enums.StatusVeiculo;
import br.com.fiap.fiapautomotors.core.port.in.ConsultarVeiculosUseCasePort;
import br.com.fiap.fiapautomotors.core.port.out.VeiculoRepositoryPort;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ListarVeiculosUseCase implements ConsultarVeiculosUseCasePort {

    private final VeiculoRepositoryPort veiculoRepositoryPort;

    public ListarVeiculosUseCase(VeiculoRepositoryPort veiculoRepositoryPort) {
        this.veiculoRepositoryPort = veiculoRepositoryPort;
    }

    @Override
    public List<Veiculo> consultar(StatusVeiculo status) {
        if (status == null){
            return veiculoRepositoryPort.consultarTodos();
        }
        return veiculoRepositoryPort.consultarPorStatus(status);
    }
}
