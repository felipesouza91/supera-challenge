package br.com.banco.domain.model;

import java.time.OffsetDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "transferencia")
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Transferencia {

  @Id
  @EqualsAndHashCode.Include
  private Integer id;

  @Column(name = "data_transferencia")
  private OffsetDateTime dataTransferencia;

  private Float valor;

  private String tipo;

  @Column(name = "nome_operador_transacao")
  private String nomeOperadorTransacao;

  @ManyToOne()
  @JoinColumn(referencedColumnName = "id_conta", name = "conta_id")
  private Conta conta;

}
