
package com.resqai.service.impl;

import com.resqai.dto.request.FirstAidRequest;
import com.resqai.dto.response.FirstAidResponse;
import com.resqai.entity.FirstAidGuide;
import com.resqai.exception.FirstAidNotFoundException;
import com.resqai.mapper.FirstAidMapper;
import com.resqai.repository.FirstAidGuideRepository;
import com.resqai.service.FirstAidService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FirstAidServiceImpl implements FirstAidService {

    private final FirstAidGuideRepository repository;
    private final FirstAidMapper mapper;

    @Override
    public FirstAidResponse create(FirstAidRequest request) {

        FirstAidGuide guide = mapper.toEntity(request);

        return mapper.toResponse(repository.save(guide));
    }

    @Override
    public List<FirstAidResponse> getAll() {

        return repository.findAll()
                .stream()
                .map(mapper::toResponse)
                .toList();
    }

    @Override
    public FirstAidResponse getByEmergencyType(String emergencyType) {

        FirstAidGuide guide = repository
                .findByEmergencyTypeIgnoreCase(emergencyType)
                .orElseThrow(() ->
                        new FirstAidNotFoundException("Guide not found.") );

        return mapper.toResponse(guide);
    }
}