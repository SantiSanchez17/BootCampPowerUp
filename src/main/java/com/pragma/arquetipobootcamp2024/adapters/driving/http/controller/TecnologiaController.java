package com.pragma.arquetipobootcamp2024.adapters.driving.http.controller;

import com.pragma.arquetipobootcamp2024.adapters.driven.jpa.mysql.entity.TecnologiaEntity;
import com.pragma.arquetipobootcamp2024.adapters.driving.http.dto.request.AddTecnologiaRequest;
import com.pragma.arquetipobootcamp2024.adapters.driving.http.dto.response.TecnologiaResponse;
import com.pragma.arquetipobootcamp2024.adapters.driving.http.mapper.ITecnologiaRequestMapper;
import com.pragma.arquetipobootcamp2024.adapters.driving.http.mapper.ITecnologiaResponseMapper;
import com.pragma.arquetipobootcamp2024.domain.api.ITecnologiaServicePort;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tecnologia")
@RequiredArgsConstructor
public class TecnologiaController {
    private final ITecnologiaServicePort tecnologiaServicePort;
    private final ITecnologiaRequestMapper tecnologiaRequestMapper;
    private final ITecnologiaResponseMapper tecnologiaResponseMapper;

    @PostMapping("/")
    public ResponseEntity<Void> addTecnologia(@RequestBody AddTecnologiaRequest request){
        tecnologiaServicePort.saveTecnologia(tecnologiaRequestMapper.addRequestToTecnologia(request));
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/{tecnologiaName}")
    public ResponseEntity<TecnologiaResponse> getTecnologia(@PathVariable String tecnologiaName){
        return ResponseEntity.ok(tecnologiaResponseMapper.toTecnologiaResponse(tecnologiaServicePort.getTecnologia(tecnologiaName)));
    }

}
