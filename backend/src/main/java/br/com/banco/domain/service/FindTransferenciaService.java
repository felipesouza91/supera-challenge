package br.com.banco.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.banco.api.filter.TranferenciaFilter;
import br.com.banco.domain.exception.ContaNaoEncontrada;
import br.com.banco.domain.model.Transferencia;
import br.com.banco.domain.repository.ContaRepository;
import br.com.banco.domain.repository.TransferenciaRepository;

@Service
public class FindTransferenciaService {

  @Autowired
  private ContaRepository contaRepository;

  @Autowired
  private TransferenciaRepository transferenciaRepository;

  public Page<Transferencia> execute(Integer contaId, TranferenciaFilter filtro, Pageable page) {
    contaRepository.findById(contaId).orElseThrow(() -> new ContaNaoEncontrada("A conta não foi encontrada"));
    Page<Transferencia> transferencias = transferenciaRepository.find(contaId, filtro, page);
    return transferencias;
  }

  public float loadTotalAmountByCountID(Integer contaId) {
    return transferenciaRepository.fetchTotalAmountByCountId(contaId);
  }

}
