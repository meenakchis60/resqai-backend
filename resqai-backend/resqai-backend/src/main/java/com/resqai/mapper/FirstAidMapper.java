
package com.resqai.mapper;

import com.resqai.dto.request.FirstAidRequest;
import com.resqai.dto.response.FirstAidResponse;
import com.resqai.entity.FirstAidGuide;
import org.springframework.stereotype.Component;

@Component
public class FirstAidMapper {

    public FirstAidGuide toEntity(FirstAidRequest request) {

        return FirstAidGuide.builder()
                .emergencyType(request.getEmergencyType())
                .symptoms(request.getSymptoms())
                .firstAidSteps(request.getFirstAidSteps())
                .build();
    }

    public FirstAidResponse toResponse(FirstAidGuide guide) {

        return FirstAidResponse.builder()
                .id(guide.getId())
                .emergencyType(guide.getEmergencyType())
                .symptoms(guide.getSymptoms())
                .firstAidSteps(guide.getFirstAidSteps())
                .build();
    }
}