
package com.resqai.controller;

import com.resqai.dto.request.FirstAidRequest;
import com.resqai.dto.response.FirstAidResponse;
import com.resqai.service.FirstAidService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

        import java.util.List;

@RestController
@RequestMapping("/api/first-aid")
@RequiredArgsConstructor
public class FirstAidController {

    private final FirstAidService firstAidService;

    @PostMapping
    public ResponseEntity<FirstAidResponse> create(
            @Valid @RequestBody FirstAidRequest request) {

        return new ResponseEntity<>(
                firstAidService.create(request),
                HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<FirstAidResponse>> getAll() {

        return ResponseEntity.ok(firstAidService.getAll());
    }

    @GetMapping("/{type}")
    public ResponseEntity<FirstAidResponse> getByType(
            @PathVariable String type) {

        return ResponseEntity.ok(
                firstAidService.getByEmergencyType(type));
    }
}