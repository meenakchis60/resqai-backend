
package com.resqai.service.impl;

import com.resqai.dto.request.SosRequestDto;
import com.resqai.dto.response.SosResponse;
import com.resqai.entity.SosRequest;
import com.resqai.entity.User;
import com.resqai.exception.SosRequestNotFoundException;
import com.resqai.mapper.SosMapper;
import com.resqai.repository.SosRequestRepository;
import com.resqai.repository.UserRepository;
import com.resqai.service.SosService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SosServiceImpl implements SosService {

    private final SosRequestRepository sosRequestRepository;
    private final UserRepository userRepository;
    private final SosMapper sosMapper;

    private User getCurrentUser() {

        Authentication authentication =
                SecurityContextHolder.getContext().getAuthentication();

        String email = authentication.getName();

        return userRepository.findByEmail(email)
                .orElseThrow(() ->
                        new RuntimeException("User not found"));
    }

    @Override
    public SosResponse sendSos(SosRequestDto request) {

        User user = getCurrentUser();

        SosRequest sosRequest = sosMapper.toEntity(request);

        sosRequest.setUser(user);
        sosRequest.setStatus("ACTIVE");
        sosRequest.setCreatedAt(LocalDateTime.now());

        SosRequest savedRequest = sosRequestRepository.save(sosRequest);

        return sosMapper.toResponse(savedRequest);
    }

    @Override
    public List<SosResponse> getSosHistory() {

        User user = getCurrentUser();

        return sosRequestRepository.findByUser(user)
                .stream()
                .map(sosMapper::toResponse)
                .toList();
    }

    @Override
    public SosResponse getSosById(Long id) {

        User user = getCurrentUser();

        SosRequest sosRequest = sosRequestRepository
                .findByIdAndUser(id, user)
                .orElseThrow(() ->
                        new SosRequestNotFoundException(
                                "SOS request not found."));

        return sosMapper.toResponse(sosRequest);
    }

    @Override
    public SosResponse resolveSos(Long id) {

        User user = getCurrentUser();

        SosRequest sosRequest = sosRequestRepository
                .findByIdAndUser(id, user)
                .orElseThrow(() ->
                        new SosRequestNotFoundException(
                                "SOS request not found."));

        sosRequest.setStatus("RESOLVED");

        SosRequest updatedRequest = sosRequestRepository.save(sosRequest);

        return sosMapper.toResponse(updatedRequest);
    }
}