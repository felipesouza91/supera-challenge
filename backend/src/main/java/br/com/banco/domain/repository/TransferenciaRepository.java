package br.com.banco.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.banco.domain.model.Transferencia;

@Repository
public interface TransferenciaRepository extends JpaRepository<Transferencia, Integer>, TransferenciaRepositoryQueries {


 

}
