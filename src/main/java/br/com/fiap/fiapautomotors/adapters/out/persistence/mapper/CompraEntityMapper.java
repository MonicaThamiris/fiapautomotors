package br.com.fiap.fiapautomotors.adapters.out.persistence.mapper;

import br.com.fiap.fiapautomotors.adapters.out.persistence.entities.CompraEntity;
import br.com.fiap.fiapautomotors.core.domain.Cliente;
import br.com.fiap.fiapautomotors.core.domain.Compra;
import br.com.fiap.fiapautomotors.core.domain.Veiculo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@AllArgsConstructor
public class CompraEntityMapper {

    private final ClienteEntityMapper clienteEntityMapper;

    private final VeiculoEntityMapper veiculoEntityMapper;

    public CompraEntity toEntity(Cliente cliente, Veiculo veiculo){
        if (cliente == null || veiculo == null){
            return null;
        }

        return CompraEntity.builder()
                .clienteEntity(clienteEntityMapper.toEntity(cliente))
                .veiculoEntity(veiculoEntityMapper.toEntity(veiculo))
                .dataHora(LocalDateTime.now().withNano(0))
                .precoPago(veiculo.getPreco())
                .build();
    }

    public Compra toModel(CompraEntity compraEntity){
        if (compraEntity == null){
            return null;
        }

        return new Compra(compraEntity.getId(),
                clienteEntityMapper.toDomain(compraEntity.getClienteEntity()),
                veiculoEntityMapper.toDomain(compraEntity.getVeiculoEntity()),
                compraEntity.getDataHora(),
                compraEntity.getPrecoPago());

    }
}
