package br.com.fiap.fiapautomotors.adapters.out.persistence.entities;

import br.com.fiap.fiapautomotors.core.enums.StatusVeiculo;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "veiculo")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class VeiculoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String modelo;

    private String marca;

    private String ano;

    private String cor;

    private BigDecimal preco;

    @Enumerated(EnumType.STRING)
    private StatusVeiculo status;

    private LocalDateTime dataHoraCriacao;

    private LocalDateTime dataHoraAtualizacao;
}
