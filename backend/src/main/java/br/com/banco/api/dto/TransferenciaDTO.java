package br.com.banco.api.dto;

import java.time.OffsetDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TransferenciaDTO {

  private Integer id;

  private OffsetDateTime dataTransferencia;

  private Float valor;

  private String tipo;

  private String nomeOperadorTransacao;

  private ContaDTO conta;
}
