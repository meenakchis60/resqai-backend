
package com.resqai.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MedicalProfileRequest {

    @NotBlank(message = "Blood group is required")
    private String bloodGroup;

    private String allergies;

    private String medicalConditions;

    private String medications;

    private String emergencyNotes;

}