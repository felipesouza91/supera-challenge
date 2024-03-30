package br.com.banco.api.controllers;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.banco.api.dto.TransferenciaDTO;
import br.com.banco.api.dto.converter.TransferenciaDTOConverter;
import br.com.banco.api.filter.TranferenciaFilter;
import br.com.banco.domain.model.Transferencia;
import br.com.banco.domain.service.FindTransferenciaService;

@RestController
@RequestMapping("/transferencias")
public class TransferenciaController {

  @Autowired
  private FindTransferenciaService transferenciaService;

  @Autowired
  private TransferenciaDTOConverter dtoConverter;

  @GetMapping("/{contaId}")
  public Page<TransferenciaDTO> find(@PathVariable Integer contaId, TranferenciaFilter filtro, Pageable page) {
    Page<Transferencia> result = transferenciaService.execute(contaId, filtro, page);
    List<TransferenciaDTO> listTransferenciaDto = dtoConverter.toListDto(result.getContent());

    return new PageImpl<>(listTransferenciaDto, page, result.getTotalElements());
  }

  @GetMapping("/{contaId}/total-amount")
  public Map<String, Float> getTotalAmoutByID(@PathVariable Integer contaId) {
    return Collections.singletonMap("amout", transferenciaService.loadTotalAmountByCountID(contaId));
  }

}
