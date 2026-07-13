
package com.resqai.service.impl;

import com.resqai.dto.request.MedicalProfileRequest;
import com.resqai.dto.response.MedicalProfileResponse;
import com.resqai.entity.MedicalProfile;
import com.resqai.entity.User;
import com.resqai.exception.MedicalProfileAlreadyExistsException;
import com.resqai.exception.MedicalProfileNotFoundException;
import com.resqai.mapper.MedicalProfileMapper;
import com.resqai.repository.MedicalProfileRepository;
import com.resqai.repository.UserRepository;
import com.resqai.service.MedicalProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MedicalProfileServiceImpl implements MedicalProfileService {

    private final MedicalProfileRepository medicalProfileRepository;
    private final UserRepository userRepository;
    private final MedicalProfileMapper medicalProfileMapper;

    private User getCurrentUser() {

        Authentication authentication =
                SecurityContextHolder.getContext().getAuthentication();

        String email = authentication.getName();

        return userRepository.findByEmail(email)
                .orElseThrow(() ->
                        new RuntimeException("User not found"));
    }
    private MedicalProfile getMedicalProfile(User user) {

        return medicalProfileRepository.findByUser(user)
                .orElseThrow(() ->
                        new MedicalProfileNotFoundException(
                                "Medical profile not found."));
    }

    @Override
    public MedicalProfileResponse createProfile(MedicalProfileRequest request) {

        User user = getCurrentUser();

        if (medicalProfileRepository.existsByUser(user)) {
            throw new MedicalProfileAlreadyExistsException(
                    "Medical profile already exists.");
        }

        MedicalProfile medicalProfile = medicalProfileMapper.toEntity(request);

        medicalProfile.setUser(user);

        MedicalProfile savedProfile = medicalProfileRepository.save(medicalProfile);

        return medicalProfileMapper.toResponse(savedProfile);
    }

    @Override
    public MedicalProfileResponse getProfile() {

        User user = getCurrentUser();

        MedicalProfile medicalProfile = getMedicalProfile(user);

        return medicalProfileMapper.toResponse(medicalProfile);
    }

    @Override
    public MedicalProfileResponse updateProfile(MedicalProfileRequest request) {

        User user = getCurrentUser();

        MedicalProfile medicalProfile = getMedicalProfile(user);

        medicalProfile.setBloodGroup(request.getBloodGroup());
        medicalProfile.setAllergies(request.getAllergies());
        medicalProfile.setMedicalConditions(request.getMedicalConditions());
        medicalProfile.setMedications(request.getMedications());
        medicalProfile.setEmergencyNotes(request.getEmergencyNotes());

        MedicalProfile updatedProfile = medicalProfileRepository.save(medicalProfile);

        return medicalProfileMapper.toResponse(updatedProfile);
    }

    @Override
    public void deleteProfile() {

        User user = getCurrentUser();

        MedicalProfile medicalProfile = getMedicalProfile(user);

        medicalProfileRepository.delete(medicalProfile);
    }
}