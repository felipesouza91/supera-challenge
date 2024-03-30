package br.com.banco.domain.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.com.banco.api.filter.TranferenciaFilter;
import br.com.banco.domain.model.Transferencia;

public interface TransferenciaRepositoryQueries {

  Page<Transferencia> find(Integer contaId, TranferenciaFilter filtro, Pageable page);

  float fetchTotalAmountByCountId(Integer countId);
}
