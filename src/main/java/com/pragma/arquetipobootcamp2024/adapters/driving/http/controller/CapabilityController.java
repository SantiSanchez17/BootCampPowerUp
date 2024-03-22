package com.pragma.arquetipobootcamp2024.adapters.driving.http.controller;

import com.pragma.arquetipobootcamp2024.adapters.driving.http.dto.request.AddCapabilityRequest;
import com.pragma.arquetipobootcamp2024.adapters.driving.http.dto.request.UpdateCapabilityRequest;
import com.pragma.arquetipobootcamp2024.adapters.driving.http.dto.response.CapabilityResponse;
import com.pragma.arquetipobootcamp2024.adapters.driving.http.mapper.ICapabilityRequestMapper;
import com.pragma.arquetipobootcamp2024.adapters.driving.http.mapper.ICapabilityResponseMapper;
import com.pragma.arquetipobootcamp2024.domain.api.ICapabilityServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/capability")
@RequiredArgsConstructor
public class CapabilityController {
    private final ICapabilityServicePort capabilityServicePort;
    private final ICapabilityRequestMapper capabilityRequestMapper;
    private final ICapabilityResponseMapper capabilityResponseMapper;

    @PostMapping("/")
    public ResponseEntity<Void> addCapability(@RequestBody AddCapabilityRequest request){
        capabilityServicePort.saveCapability(capabilityRequestMapper.addRequestToCapability(request));
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    @PutMapping("/")
    public ResponseEntity<CapabilityResponse> updateCapability(@RequestBody UpdateCapabilityRequest request){
        return ResponseEntity.ok(capabilityResponseMapper.toCapabilityResponse(
                capabilityServicePort.updateCapability(capabilityRequestMapper.updateRequestToCapability(request))
        ));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTecnology(@PathVariable Long id){
        capabilityServicePort.deleteCapability(id);
        return ResponseEntity.noContent().build();
    }
}
