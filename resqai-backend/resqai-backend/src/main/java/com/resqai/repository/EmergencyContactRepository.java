package com.resqai.repository;

import com.resqai.entity.EmergencyContact;
import com.resqai.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface EmergencyContactRepository extends JpaRepository<EmergencyContact, Long> {

    List<EmergencyContact> findByUser(User user);

    Optional<EmergencyContact> findByIdAndUser(Long id, User user);

}