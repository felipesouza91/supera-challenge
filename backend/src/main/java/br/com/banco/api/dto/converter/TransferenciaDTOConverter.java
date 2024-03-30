package br.com.banco.api.dto.converter;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.banco.api.dto.TransferenciaDTO;
import br.com.banco.domain.model.Transferencia;

@Component
public class TransferenciaDTOConverter {
  @Autowired
  private ModelMapper modelMapper;

  public TransferenciaDTO toDto(Transferencia transferencia) {
    return modelMapper.map(transferencia, TransferenciaDTO.class);
  }

  public List<TransferenciaDTO> toListDto(List<Transferencia> list) {
    return list.stream().map(transferencia -> toDto(transferencia)).collect(Collectors.toList());
  }
}
