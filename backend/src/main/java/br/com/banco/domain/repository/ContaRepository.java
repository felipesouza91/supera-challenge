package br.com.banco.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.banco.domain.model.Conta;

public interface ContaRepository extends JpaRepository<Conta, Integer> {

}
