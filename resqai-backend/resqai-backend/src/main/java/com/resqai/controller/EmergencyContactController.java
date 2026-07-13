
package com.resqai.controller;

import com.resqai.dto.request.EmergencyContactRequest;
import com.resqai.dto.response.EmergencyContactResponse;
import com.resqai.service.EmergencyContactService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

        import java.util.List;

@RestController
@RequestMapping("/api/emergency-contacts")
@RequiredArgsConstructor
public class EmergencyContactController {

    private final EmergencyContactService emergencyContactService;

    @PostMapping
    public ResponseEntity<EmergencyContactResponse> addContact(
            @Valid @RequestBody EmergencyContactRequest request) {

        return new ResponseEntity<>(
                emergencyContactService.addContact(request),
                HttpStatus.CREATED
        );
    }

    @GetMapping
    public ResponseEntity<List<EmergencyContactResponse>> getAllContacts() {

        return ResponseEntity.ok(
                emergencyContactService.getAllContacts()
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmergencyContactResponse> updateContact(
            @PathVariable Long id,
            @Valid @RequestBody EmergencyContactRequest request) {

        return ResponseEntity.ok(
                emergencyContactService.updateContact(id, request)
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteContact(
            @PathVariable Long id) {

        emergencyContactService.deleteContact(id);

        return ResponseEntity.ok(
                "Emergency contact deleted successfully."
        );
    }
}