package com.onboarding.backend.repository;

import com.onboarding.backend.model.CompaniesHouseData;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface CompaniesHouseDataRepository extends JpaRepository<CompaniesHouseData, Long> {
    Optional<CompaniesHouseData> findByCaseId(String caseId);
}