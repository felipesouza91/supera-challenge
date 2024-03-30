package br.com.banco.domain.repository.impl;

import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import br.com.banco.api.filter.TranferenciaFilter;
import br.com.banco.domain.model.Transferencia;
import br.com.banco.domain.repository.TransferenciaRepositoryQueries;

public class TransferenciaRepositoryImpl implements TransferenciaRepositoryQueries {

  @PersistenceContext
  private EntityManager manager;

  @Override
  public Page<Transferencia> find(Integer contaId, TranferenciaFilter filtro, Pageable page) {

    CriteriaBuilder builder = manager.getCriteriaBuilder();
    CriteriaQuery<Transferencia> criteria = builder.createQuery(Transferencia.class);
    Root<Transferencia> root = criteria.from(Transferencia.class);
    criteria.select(root);
    Predicate[] predicates = createFilter(contaId, filtro, builder, root);

    criteria.where(predicates);

    TypedQuery<Transferencia> query = manager.createQuery(criteria);

    int paginaAtual = page.getPageNumber();
    int totalPagina = page.getPageSize();
    int primeiroRegistroPagina = paginaAtual * totalPagina;
    query.setFirstResult(primeiroRegistroPagina);
    query.setMaxResults(totalPagina);
    Page<Transferencia> results = new PageImpl<>(query.getResultList(), page, total(contaId, filtro));
    return results;

  }

  private Predicate[] createFilter(Integer contaId, TranferenciaFilter filtro, CriteriaBuilder builder,
      Root<Transferencia> root) {
    List<Predicate> predicates = new ArrayList<>();
    predicates.add(builder.equal(root.get("conta").get("id"), contaId));
    if (filtro.getDataInicio() != null) {
      predicates.add(builder.greaterThanOrEqualTo(root.get("dataTransferencia"),
          filtro.getDataInicio().atStartOfDay().atOffset(ZoneOffset.UTC)));
    }

    if (filtro.getDataFim() != null) {
      predicates.add(builder.lessThanOrEqualTo(root.get("dataTransferencia"),
          filtro.getDataFim().atStartOfDay().withHour(23).withMinute(59).withSecond(59).atOffset(ZoneOffset.UTC)));
    }

    if (filtro.getNomeOperador() != null && !filtro.getNomeOperador().isEmpty()) {
      predicates.add(builder.like(builder.lower(root.get("nomeOperadorTransacao")),
          "%" + filtro.getNomeOperador().toLowerCase() + "%"));
    }

    return predicates.toArray(new Predicate[predicates.size()]);
  }

  private Long total(Integer contaId, TranferenciaFilter clienteFilter) {
    CriteriaBuilder builder = manager.getCriteriaBuilder();
    CriteriaQuery<Long> criteria = builder.createQuery(Long.class);
    Root<Transferencia> root = criteria.from(Transferencia.class);
    Predicate[] predicates = createFilter(contaId, clienteFilter, builder, root);
    criteria.where(predicates);
    criteria.select(builder.count(root));
    return manager.createQuery(criteria).getSingleResult();
  }

  @Override
  public float fetchTotalAmountByCountId(Integer countId) {
    CriteriaBuilder builder = manager.getCriteriaBuilder();
    CriteriaQuery<Float> criteria = builder.createQuery(Float.class);
    Root<Transferencia> root = criteria.from(Transferencia.class);
    criteria.where(builder.equal(root.get("conta").get("id"), countId));
    criteria.select(builder.sum(root.get("valor")));
    return manager.createQuery(criteria).getSingleResult();
  }
}
