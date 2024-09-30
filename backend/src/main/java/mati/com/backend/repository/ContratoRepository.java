package mati.com.backend.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mati.com.backend.model.ContratoModel;

/**
 * ContratoRepository
 */
@Repository
public interface ContratoRepository extends JpaRepository<ContratoModel, UUID>{
        List<ContratoModel> findAll();
}