package br.com.banco.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "conta")
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Conta {

  @Id
  @Column(name = "id_conta")
  @EqualsAndHashCode.Include
  private Integer id;

  @Column(name = "nome_responsavel")
  private String nomeResponsavel;

}
