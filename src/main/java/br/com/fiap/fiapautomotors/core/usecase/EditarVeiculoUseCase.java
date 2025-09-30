package br.com.fiap.fiapautomotors.core.usecase;

import br.com.fiap.fiapautomotors.adapters.out.persistence.entities.VeiculoEntity;
import br.com.fiap.fiapautomotors.core.domain.Veiculo;
import br.com.fiap.fiapautomotors.core.port.in.EditarVeiculoUseCasePort;
import br.com.fiap.fiapautomotors.core.port.out.VeiculoRepositoryPort;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Optional;

@Component
public class EditarVeiculoUseCase implements EditarVeiculoUseCasePort {

    private final VeiculoRepositoryPort veiculoRepositoryPort;

    public EditarVeiculoUseCase(VeiculoRepositoryPort veiculoRepositoryPort) {
        this.veiculoRepositoryPort = veiculoRepositoryPort;
    }

    @Override
    public Veiculo editar(String id, Veiculo veiculo) {
        Optional<Veiculo> veiculoOptional = veiculoRepositoryPort.buscarPorId(id);

        if (veiculoOptional.isEmpty()) {
            throw new RuntimeException(String.format("O veículo de ID %s não existe", id));
        }

        Veiculo veiculoExistente = veiculoOptional.get();

        setIfNotNull(veiculo.getModelo(), veiculoExistente::setModelo);
        setIfNotNull(veiculo.getMarca(), veiculoExistente::setMarca);
        setIfNotNull(veiculo.getAno(), veiculoExistente::setAno);
        setIfNotNull(veiculo.getCor(), veiculoExistente::setCor);
        setIfNotNull(veiculo.getPreco(), veiculoExistente::setPreco);
        setIfNotNull(veiculo.getStatus(), veiculoExistente::setStatus);

        veiculoExistente.setDataHoraAtualizacao(LocalDateTime.now().withNano(0));
        return veiculoRepositoryPort.salvar(veiculoExistente);
    }

    private static <T> void setIfNotNull(T value, java.util.function.Consumer<T> setter) {
        if (value != null) setter.accept(value);
    }

}
