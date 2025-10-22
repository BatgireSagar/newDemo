package com.onboarding.backend.service;

import com.onboarding.backend.dto.AiAnalyzeRequestDTO;
import com.onboarding.backend.dto.AiAnalyzeResponseDTO;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class BedrockAiService {
    public AiAnalyzeResponseDTO analyze(AiAnalyzeRequestDTO request) {
        // TODO: Integrate with AWS Bedrock API using RestTemplate/WebClient and credentials
        // For now, return a mock response
        AiAnalyzeResponseDTO.Conflict conflict = AiAnalyzeResponseDTO.Conflict.builder()
                .field("registeredAddress")
                .issue("Mismatch")
                .build();
        return AiAnalyzeResponseDTO.builder()
                .conflicts(Collections.singletonList(conflict))
                .missingFields(Collections.singletonList("dateOfIncorporation"))
                .recommendation("Fast Track")
                .build();
    }
}