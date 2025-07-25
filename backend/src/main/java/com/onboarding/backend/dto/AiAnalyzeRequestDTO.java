package com.onboarding.backend.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AiAnalyzeRequestDTO {
    private ClientInfoDTO submittedData;
    private ComparisonDataDTO.ExternalData companiesHouse;
    private ComparisonDataDTO.ExternalData customerSystem;
}