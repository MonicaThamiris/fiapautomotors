package br.com.fiap.fiapautomotors.adapters.out.persistence.mapper;

import br.com.fiap.fiapautomotors.adapters.out.persistence.entities.VeiculoEntity;
import br.com.fiap.fiapautomotors.core.domain.Veiculo;
import br.com.fiap.fiapautomotors.core.enums.StatusVeiculo;
import org.springframework.stereotype.Component;

@Component
public class VeiculoEntityMapper {

    public VeiculoEntity toEntity(Veiculo veiculo){
        if (veiculo == null){
            return null;
        }

        return new VeiculoEntity(
                veiculo.getId(),
                veiculo.getModelo(),
                veiculo.getMarca(),
                veiculo.getAno(),
                veiculo.getCor(),
                veiculo.getPreco(),
                veiculo.getStatus(),
                veiculo.getDataHoraCriacao(),
                veiculo.getDataHoraAtualizacao());
    }

    public Veiculo toDomain(VeiculoEntity veiculoEntity){
        if (veiculoEntity == null){
            return null;
        }

        return new Veiculo(veiculoEntity.getId(),
                veiculoEntity.getMarca(),
                veiculoEntity.getModelo(),
                veiculoEntity.getAno(),
                veiculoEntity.getCor(),
                veiculoEntity.getPreco(),
                veiculoEntity.getStatus(),
                veiculoEntity.getDataHoraCriacao(),
                veiculoEntity.getDataHoraAtualizacao());
    }
}
