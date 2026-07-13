
package com.resqai.mapper;

import com.resqai.dto.request.SosRequestDto;
import com.resqai.dto.response.SosResponse;
import com.resqai.entity.SosRequest;
import org.springframework.stereotype.Component;

@Component
public class SosMapper {

    public SosRequest toEntity(SosRequestDto request) {

        return SosRequest.builder()
                .latitude(request.getLatitude())
                .longitude(request.getLongitude())
                .build();
    }

    public SosResponse toResponse(SosRequest sosRequest) {

        return SosResponse.builder()
                .id(sosRequest.getId())
                .latitude(sosRequest.getLatitude())
                .longitude(sosRequest.getLongitude())
                .status(sosRequest.getStatus())
                .createdAt(sosRequest.getCreatedAt())
                .build();
    }
}