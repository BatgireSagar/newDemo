package com.onboarding.backend.service;

import com.onboarding.backend.model.CaseJourney;
import com.onboarding.backend.repository.CaseJourneyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CaseJourneyService {
    private final CaseJourneyRepository caseJourneyRepository;

    public CaseJourney save(CaseJourney caseJourney) {
        return caseJourneyRepository.save(caseJourney);
    }

    public Optional<CaseJourney> findByCaseId(String caseId) {
        return caseJourneyRepository.findByCaseId(caseId);
    }

    public List<CaseJourney> getAll() {
        return caseJourneyRepository.findAll();
    }
}