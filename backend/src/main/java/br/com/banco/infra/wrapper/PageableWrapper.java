package br.com.banco.infra.wrapper;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class PageableWrapper<T> {

  private List<T> content;

  private long totalElements;

  private long totalPages;

  private long size;

}
