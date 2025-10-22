package com.onboarding.backend.service;

import com.onboarding.backend.model.CompaniesHouseData;
import com.onboarding.backend.repository.CompaniesHouseDataRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CompaniesHouseDataService {
    private final CompaniesHouseDataRepository companiesHouseDataRepository;

    public CompaniesHouseData save(CompaniesHouseData data) {
        return companiesHouseDataRepository.save(data);
    }

    public Optional<CompaniesHouseData> findByCaseId(String caseId) {
        return companiesHouseDataRepository.findByCaseId(caseId);
    }

    public List<CompaniesHouseData> getAll() {
        return companiesHouseDataRepository.findAll();
    }
}