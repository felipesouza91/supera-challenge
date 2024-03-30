package br.com.banco.api.filter;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TranferenciaFilter {

  private LocalDate dataInicio;

  private LocalDate dataFim;

  private String nomeOperador;
}
