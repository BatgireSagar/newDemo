package com.onboarding.backend.repository;

import com.onboarding.backend.model.ClientInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface ClientInfoRepository extends JpaRepository<ClientInfo, Long> {
    Optional<ClientInfo> findByCaseId(String caseId);
}