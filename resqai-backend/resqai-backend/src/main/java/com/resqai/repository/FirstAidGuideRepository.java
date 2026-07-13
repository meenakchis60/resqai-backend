
package com.resqai.repository;

import com.resqai.entity.FirstAidGuide;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FirstAidGuideRepository
        extends JpaRepository<FirstAidGuide, Long> {

    Optional<FirstAidGuide> findByEmergencyTypeIgnoreCase(
            String emergencyType);
}