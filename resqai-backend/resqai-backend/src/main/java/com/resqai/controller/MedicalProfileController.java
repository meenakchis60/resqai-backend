
package com.resqai.controller;

import com.resqai.dto.request.MedicalProfileRequest;
import com.resqai.dto.response.MedicalProfileResponse;
import com.resqai.service.MedicalProfileService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/medical-profile")
@RequiredArgsConstructor
public class MedicalProfileController {

    private final MedicalProfileService medicalProfileService;

    @PostMapping
    public ResponseEntity<MedicalProfileResponse> createProfile(
            @Valid @RequestBody MedicalProfileRequest request) {

        return new ResponseEntity<>(
                medicalProfileService.createProfile(request),
                HttpStatus.CREATED
        );
    }

    @GetMapping
    public ResponseEntity<MedicalProfileResponse> getProfile() {

        return ResponseEntity.ok(
                medicalProfileService.getProfile()
        );
    }

    @PutMapping
    public ResponseEntity<MedicalProfileResponse> updateProfile(
            @Valid @RequestBody MedicalProfileRequest request) {

        return ResponseEntity.ok(
                medicalProfileService.updateProfile(request)
        );
    }

    @DeleteMapping
    public ResponseEntity<String> deleteProfile() {

        medicalProfileService.deleteProfile();

        return ResponseEntity.ok("Medical profile deleted successfully.");
    }
}