package com.onboarding.kyc.web.dto;

import lombok.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ApiAiAssessmentResponse {
    private List<Conflict> conflicts;
    private List<String> missingFields;
    private String recommendation;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class Conflict {
        private String field;
        private String issue;
    }
}