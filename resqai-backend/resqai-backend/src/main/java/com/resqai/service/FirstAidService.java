
package com.resqai.service;

import com.resqai.dto.request.FirstAidRequest;
import com.resqai.dto.response.FirstAidResponse;

import java.util.List;

public interface FirstAidService {

    FirstAidResponse create(FirstAidRequest request);

    List<FirstAidResponse> getAll();

    FirstAidResponse getByEmergencyType(String emergencyType);
}