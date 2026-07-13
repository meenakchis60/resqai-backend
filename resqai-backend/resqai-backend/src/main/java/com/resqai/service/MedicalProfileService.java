

package com.resqai.service;

import com.resqai.dto.request.MedicalProfileRequest;
import com.resqai.dto.response.MedicalProfileResponse;

public interface MedicalProfileService {

    MedicalProfileResponse createProfile(MedicalProfileRequest request);

    MedicalProfileResponse getProfile();

    MedicalProfileResponse updateProfile(MedicalProfileRequest request);

    void deleteProfile();

}