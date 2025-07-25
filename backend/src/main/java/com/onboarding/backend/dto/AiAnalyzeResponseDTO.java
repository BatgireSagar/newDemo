package com.onboarding.backend.dto;

import lombok.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AiAnalyzeResponseDTO {
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