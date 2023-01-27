package com.technical.test.repository;

import com.technical.test.model.entity.Empresa;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface EmpresaRepository extends CrudRepository<Empresa, Long> {

    Optional<Empresa> findByRuc(String ruc);

    List<Empresa> findTop3ByOrderByIdEmpresaDesc();

}
