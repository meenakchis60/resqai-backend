package com.resqai.service;

import com.resqai.dto.request.SosRequestDto;
import com.resqai.dto.response.SosResponse;

import java.util.List;

public interface SosService {

    SosResponse sendSos(SosRequestDto request);

    List<SosResponse> getSosHistory();

    SosResponse getSosById(Long id);

    SosResponse resolveSos(Long id);
}
