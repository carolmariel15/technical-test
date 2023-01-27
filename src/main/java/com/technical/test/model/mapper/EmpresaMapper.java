package com.technical.test.model.mapper;

import com.technical.test.model.dto.EmpresaRequestDto;
import com.technical.test.model.dto.EmpresaResponseDto;
import com.technical.test.model.entity.Empresa;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface EmpresaMapper {

    @Mapping(source = "empresa.idEmpresa", target = "idEmpresa")
    @Mapping(source = "empresa.ruc", target = "ruc")
    @Mapping(source = "empresa.razonSocial", target = "razonSocial")
    @Mapping(source = "empresa.direccion", target = "direccion")
    @Mapping(source = "empresa.estado", target = "estado")
    EmpresaResponseDto entityToResponse(Empresa empresa);

    @Mapping(source = "empresa.ruc", target = "ruc")
    @Mapping(source = "empresa.razonSocial", target = "razonSocial")
    @Mapping(source = "empresa.direccion", target = "direccion")
    @Mapping(source = "empresa.estado", target = "estado")
    Empresa requestToEntity(EmpresaRequestDto empresa);

}
