
package com.resqai.mapper;

import com.resqai.dto.request.EmergencyContactRequest;
import com.resqai.dto.response.EmergencyContactResponse;
import com.resqai.entity.EmergencyContact;
import org.springframework.stereotype.Component;

@Component
public class EmergencyContactMapper {

    public EmergencyContact toEntity(EmergencyContactRequest request) {

        return EmergencyContact.builder()
                .name(request.getName())
                .relationship(request.getRelationship())
                .phoneNumber(request.getPhoneNumber())
                .priority(request.getPriority() != null ? request.getPriority() : 1)
                .build();
    }

    public EmergencyContactResponse toResponse(EmergencyContact contact) {

        return EmergencyContactResponse.builder()
                .id(contact.getId())
                .name(contact.getName())
                .relationship(contact.getRelationship())
                .phoneNumber(contact.getPhoneNumber())
                .priority(contact.getPriority())
                .build();
    }
}