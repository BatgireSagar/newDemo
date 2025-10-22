package com.onboarding.backend.repository;

import com.onboarding.backend.model.AiResults;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface AiResultsRepository extends JpaRepository<AiResults, Long> {
    Optional<AiResults> findByCaseId(String caseId);
}