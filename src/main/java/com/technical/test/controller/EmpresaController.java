package com.technical.test.controller;

import com.technical.test.model.dto.EmpresaRequestDto;
import com.technical.test.model.dto.EmpresaResponseDto;
import com.technical.test.service.EmpresaService;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/empresa")
@Primary
public class EmpresaController {

    private final EmpresaService empresaService;

    @PostMapping
    public ResponseEntity<EmpresaResponseDto> registrarEmpresa(
            @Valid @RequestBody EmpresaRequestDto requestDto) {
        var response = empresaService.registrarEmpresa(requestDto);
        return ResponseEntity
                .created(URI.create("/" + response.getIdEmpresa()))
                .body(response);
    }

    @GetMapping
    public ResponseEntity<List<EmpresaResponseDto>> listarEmpresas() {
        var response = empresaService.listarEmpresas();
        return ResponseEntity.ok(response);
    }

}
