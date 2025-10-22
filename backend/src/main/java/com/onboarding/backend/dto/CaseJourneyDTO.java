package com.onboarding.kyc.web.dto;

import lombok.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ApiOnboardingJourneyResponse {
    private String caseId;
    private String journeyStatus;
    private LocalDateTime lastUpdated;
}