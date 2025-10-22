package com.onboarding.backend.service;

import com.onboarding.backend.model.AiResults;
import com.onboarding.backend.repository.AiResultsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AiResultsService {
    private final AiResultsRepository aiResultsRepository;

    public AiResults save(AiResults aiResults) {
        return aiResultsRepository.save(aiResults);
    }

    public Optional<AiResults> findByCaseId(String caseId) {
        return aiResultsRepository.findByCaseId(caseId);
    }

    public List<AiResults> getAll() {
        return aiResultsRepository.findAll();
    }
}