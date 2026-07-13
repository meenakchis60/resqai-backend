
package com.resqai.mapper;

import com.resqai.dto.request.MedicalProfileRequest;
import com.resqai.dto.response.MedicalProfileResponse;
import com.resqai.entity.MedicalProfile;
import org.springframework.stereotype.Component;

@Component
public class MedicalProfileMapper {

    public MedicalProfile toEntity(MedicalProfileRequest request) {

        return MedicalProfile.builder()
                .bloodGroup(request.getBloodGroup())
                .allergies(request.getAllergies())
                .medicalConditions(request.getMedicalConditions())
                .medications(request.getMedications())
                .emergencyNotes(request.getEmergencyNotes())
                .build();
    }

    public MedicalProfileResponse toResponse(MedicalProfile profile) {

        return MedicalProfileResponse.builder()
                .id(profile.getId())
                .bloodGroup(profile.getBloodGroup())
                .allergies(profile.getAllergies())
                .medicalConditions(profile.getMedicalConditions())
                .medications(profile.getMedications())
                .emergencyNotes(profile.getEmergencyNotes())
                .build();
    }
}