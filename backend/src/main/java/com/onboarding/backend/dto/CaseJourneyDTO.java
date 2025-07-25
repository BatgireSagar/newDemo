package com.onboarding.backend.dto;

import lombok.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CaseJourneyDTO {
    private String caseId;
    private String journeyStatus;
    private LocalDateTime lastUpdated;
}