
package com.resqai.service;

import com.resqai.dto.request.EmergencyContactRequest;
import com.resqai.dto.response.EmergencyContactResponse;

import java.util.List;

public interface EmergencyContactService {

    EmergencyContactResponse addContact(EmergencyContactRequest request);

    List<EmergencyContactResponse> getAllContacts();

    EmergencyContactResponse updateContact(
            Long id,
            EmergencyContactRequest request
    );

    void deleteContact(Long id);

}