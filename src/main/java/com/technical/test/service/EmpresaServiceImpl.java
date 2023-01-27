package com.technical.test.service;

import com.technical.test.configuration.ResourceNotFoundException;
import com.technical.test.model.dto.EmpresaRequestDto;
import com.technical.test.model.dto.EmpresaResponseDto;
import com.technical.test.model.mapper.EmpresaMapper;
import com.technical.test.repository.EmpresaRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class EmpresaServiceImpl implements EmpresaService {

    private final EmpresaRepository empresaRepository;

    private final EmpresaMapper empresaMapper;

    @Override
    public EmpresaResponseDto registrarEmpresa(EmpresaRequestDto empresa) {
        var empresaEntity = empresaMapper.requestToEntity(empresa);
        if (empresaRepository.findByRuc(empresa.getRuc()).isPresent())
            throw new ResourceNotFoundException("La empresa ya existe.", HttpStatus.CONFLICT);
        else
            return empresaMapper.entityToResponse(empresaRepository.save(empresaEntity));
    }

    @Override
    public List<EmpresaResponseDto> listarEmpresas() {
        var lista = empresaRepository.findTop3ByOrderByIdEmpresaDesc();
        return lista.stream()
                .map(empresaMapper::entityToResponse)
                .collect(Collectors.toList());
    }

}
