package com.onboarding.backend.repository;

import com.onboarding.backend.model.CaseJourney;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface CaseJourneyRepository extends JpaRepository<CaseJourney, Long> {
    Optional<CaseJourney> findByCaseId(String caseId);
}