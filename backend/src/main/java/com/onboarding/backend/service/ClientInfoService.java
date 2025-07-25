package com.onboarding.backend.service;

import com.onboarding.backend.model.ClientInfo;
import com.onboarding.backend.repository.ClientInfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClientInfoService {
    private final ClientInfoRepository clientInfoRepository;

    public ClientInfo save(ClientInfo clientInfo) {
        return clientInfoRepository.save(clientInfo);
    }

    public Optional<ClientInfo> findByCaseId(String caseId) {
        return clientInfoRepository.findByCaseId(caseId);
    }

    public List<ClientInfo> getAll() {
        return clientInfoRepository.findAll();
    }
}