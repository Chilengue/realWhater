package mati.com.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import mati.com.backend.model.PagamentosModel;

public interface PagamentosRepository extends JpaRepository<PagamentosModel, Long> {
    
}
