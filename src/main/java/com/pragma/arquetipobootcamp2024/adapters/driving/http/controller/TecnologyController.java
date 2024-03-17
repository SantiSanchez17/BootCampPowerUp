package com.pragma.arquetipobootcamp2024.adapters.driving.http.controller;

import com.pragma.arquetipobootcamp2024.adapters.driving.http.dto.request.AddTecnologyRequest;
import com.pragma.arquetipobootcamp2024.adapters.driving.http.dto.request.UpdateTecnologyRequest;
import com.pragma.arquetipobootcamp2024.adapters.driving.http.dto.response.TecnologyResponse;
import com.pragma.arquetipobootcamp2024.adapters.driving.http.mapper.ITecnologyRequestMapper;
import com.pragma.arquetipobootcamp2024.adapters.driving.http.mapper.ITecnologyResponseMapper;
import com.pragma.arquetipobootcamp2024.domain.api.ITecnologyServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tecnology")
@RequiredArgsConstructor
public class TecnologyController {
    private final ITecnologyServicePort tecnologyServicePort;
    private final ITecnologyRequestMapper tecnologyRequestMapper;
    private final ITecnologyResponseMapper tecnologyResponseMapper;

    @PostMapping("/")
    public ResponseEntity<Void> addTecnology(@RequestBody AddTecnologyRequest request){
        tecnologyServicePort.saveTecnology(tecnologyRequestMapper.addRequestToTecnology(request));
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/search/{tecnologyName}")
    public ResponseEntity<TecnologyResponse> getTecnology(@PathVariable String tecnologyName){
        return ResponseEntity.ok(tecnologyResponseMapper.toTecnologyResponse(tecnologyServicePort.getTecnology(tecnologyName)));
    }

    @GetMapping("/")
    public ResponseEntity<List<TecnologyResponse>> getAllTecnologys(@RequestParam Integer page, @RequestParam Integer size, @RequestParam String sort) {
        return ResponseEntity.ok(tecnologyResponseMapper.
                toTecnologyResponseList(tecnologyServicePort.getAllTecnologys(page, size,sort)));
    }

    @PutMapping("/")
    public ResponseEntity<TecnologyResponse> updateTecnology(@RequestBody UpdateTecnologyRequest request) {
        return ResponseEntity.ok(tecnologyResponseMapper.toTecnologyResponse(
                tecnologyServicePort.updateTecnology(tecnologyRequestMapper.updateRequestToTecnology(request))
        ));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTecnology(@PathVariable Long id) {
        tecnologyServicePort.deleteTecnologia(id);
        return ResponseEntity.noContent().build();
    }
}
