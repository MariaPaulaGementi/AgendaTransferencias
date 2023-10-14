package com.agenda.transferencias.Repository;


import com.agenda.transferencias.DTO.Transferencia;
import org.springframework.data.repository.CrudRepository;

public interface TransferenciaRepository extends CrudRepository<Transferencia, Long> {
    Transferencia findById(long id);
}