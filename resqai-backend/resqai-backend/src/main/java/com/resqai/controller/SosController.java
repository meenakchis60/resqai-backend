
package com.resqai.controller;

import com.resqai.dto.request.SosRequestDto;
import com.resqai.dto.response.SosResponse;
import com.resqai.service.SosService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

        import java.util.List;

@RestController
@RequestMapping("/api/sos")
@RequiredArgsConstructor
public class SosController {

    private final SosService sosService;

    @PostMapping
    public ResponseEntity<SosResponse> sendSos(
            @Valid @RequestBody SosRequestDto request) {

        return new ResponseEntity<>(
                sosService.sendSos(request),
                HttpStatus.CREATED
        );
    }

    @GetMapping("/history")
    public ResponseEntity<List<SosResponse>> getHistory() {

        return ResponseEntity.ok(
                sosService.getSosHistory()
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<SosResponse> getSosById(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                sosService.getSosById(id)
        );
    }

    @PutMapping("/{id}/resolve")
    public ResponseEntity<SosResponse> resolveSos(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                sosService.resolveSos(id)
        );
    }
}