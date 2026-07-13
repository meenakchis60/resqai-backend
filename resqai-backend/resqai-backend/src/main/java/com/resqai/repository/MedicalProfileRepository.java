

package com.resqai.repository;

import com.resqai.entity.MedicalProfile;
import com.resqai.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MedicalProfileRepository extends JpaRepository<MedicalProfile, Long> {

    Optional<MedicalProfile> findByUser(User user);

    boolean existsByUser(User user);

}