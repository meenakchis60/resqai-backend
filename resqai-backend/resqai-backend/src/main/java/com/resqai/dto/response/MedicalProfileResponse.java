
package com.resqai.dto.response;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MedicalProfileResponse {

    private Long id;

    private String bloodGroup;

    private String allergies;

    private String medicalConditions;

    private String medications;

    private String emergencyNotes;

}