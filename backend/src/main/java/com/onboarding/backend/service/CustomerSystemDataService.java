package com.onboarding.backend.service;

import com.onboarding.backend.model.CustomerSystemData;
import com.onboarding.backend.repository.CustomerSystemDataRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerSystemDataService {
    private final CustomerSystemDataRepository customerSystemDataRepository;

    public CustomerSystemData save(CustomerSystemData data) {
        return customerSystemDataRepository.save(data);
    }

    public Optional<CustomerSystemData> findByCaseId(String caseId) {
        return customerSystemDataRepository.findByCaseId(caseId);
    }

    public List<CustomerSystemData> getAll() {
        return customerSystemDataRepository.findAll();
    }
}