
package com.resqai.repository;

import com.resqai.entity.SosRequest;
import com.resqai.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SosRequestRepository extends JpaRepository<SosRequest, Long> {

    List<SosRequest> findByUser(User user);

    Optional<SosRequest> findByIdAndUser(Long id, User user);

}