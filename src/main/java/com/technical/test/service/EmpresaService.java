package com.technical.test.service;

import com.technical.test.model.dto.EmpresaRequestDto;
import com.technical.test.model.dto.EmpresaResponseDto;
import com.technical.test.model.entity.Empresa;

import java.util.List;

public interface EmpresaService {

    EmpresaResponseDto registrarEmpresa(EmpresaRequestDto empresa);

    List<EmpresaResponseDto> listarEmpresas();

}
