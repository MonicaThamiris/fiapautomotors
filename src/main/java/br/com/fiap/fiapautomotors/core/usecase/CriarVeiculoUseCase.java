package br.com.fiap.fiapautomotors.core.usecase;

import br.com.fiap.fiapautomotors.core.domain.Veiculo;
import br.com.fiap.fiapautomotors.core.enums.StatusVeiculo;
import br.com.fiap.fiapautomotors.core.port.in.CriarVeiculoUseCasePort;
import br.com.fiap.fiapautomotors.core.port.out.VeiculoRepositoryPort;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class CriarVeiculoUseCase implements CriarVeiculoUseCasePort {

    private final VeiculoRepositoryPort veiculoRepositoryPort;

    public CriarVeiculoUseCase(VeiculoRepositoryPort veiculoRepositoryPort) {
        this.veiculoRepositoryPort = veiculoRepositoryPort;
    }

    @Override
    public Veiculo criar(Veiculo veiculo) {
        veiculo.setStatus(StatusVeiculo.DISPONIVEL);
        veiculo.setDataHoraCriacao(LocalDateTime.now().withNano(0));
        return veiculoRepositoryPort.salvar(veiculo);
    }
}
