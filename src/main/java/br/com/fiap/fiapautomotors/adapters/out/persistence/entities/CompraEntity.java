package br.com.fiap.fiapautomotors.adapters.out.persistence.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "compra")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CompraEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @ManyToOne
    private ClienteEntity clienteEntity;

    @ManyToOne
    private VeiculoEntity veiculoEntity;

    private LocalDateTime dataHora;

    private BigDecimal precoPago;
}
