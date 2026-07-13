
package com.resqai.service.impl;

import com.resqai.dto.request.EmergencyContactRequest;
import com.resqai.dto.response.EmergencyContactResponse;
import com.resqai.entity.EmergencyContact;
import com.resqai.entity.User;
import com.resqai.exception.EmergencyContactNotFoundException;
import com.resqai.mapper.EmergencyContactMapper;
import com.resqai.repository.EmergencyContactRepository;
import com.resqai.repository.UserRepository;
import com.resqai.service.EmergencyContactService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmergencyContactServiceImpl implements EmergencyContactService {

    private final EmergencyContactRepository emergencyContactRepository;
    private final UserRepository userRepository;
    private final EmergencyContactMapper emergencyContactMapper;

    private User getCurrentUser() {

        Authentication authentication =
                SecurityContextHolder.getContext().getAuthentication();

        String email = authentication.getName();

        return userRepository.findByEmail(email)
                .orElseThrow(() ->
                        new RuntimeException("User not found"));
    }

    @Override
    public EmergencyContactResponse addContact(EmergencyContactRequest request) {

        User user = getCurrentUser();

        EmergencyContact contact =
                emergencyContactMapper.toEntity(request);

        contact.setUser(user);

        EmergencyContact savedContact =
                emergencyContactRepository.save(contact);

        return emergencyContactMapper.toResponse(savedContact);
    }

    @Override
    public List<EmergencyContactResponse> getAllContacts() {

        User user = getCurrentUser();

        List<EmergencyContact> contacts =
                emergencyContactRepository.findByUser(user);

        return contacts.stream()
                .map(emergencyContactMapper::toResponse)
                .toList();
    }

    @Override
    public EmergencyContactResponse updateContact(
            Long id,
            EmergencyContactRequest request) {

        User user = getCurrentUser();

        EmergencyContact contact = emergencyContactRepository
                .findByIdAndUser(id, user)
                .orElseThrow(() ->
                        new EmergencyContactNotFoundException(
                                "Emergency contact not found."));

        contact.setName(request.getName());
        contact.setRelationship(request.getRelationship());
        contact.setPhoneNumber(request.getPhoneNumber());
        contact.setPriority(request.getPriority() != null ? request.getPriority() : 1);

        EmergencyContact updatedContact =
                emergencyContactRepository.save(contact);

        return emergencyContactMapper.toResponse(updatedContact);
    }

    @Override
    public void deleteContact(Long id) {

        User user = getCurrentUser();

        EmergencyContact contact = emergencyContactRepository
                .findByIdAndUser(id, user)
                .orElseThrow(() ->
                        new EmergencyContactNotFoundException(
                                "Emergency contact not found."));

        emergencyContactRepository.delete(contact);
    }
}