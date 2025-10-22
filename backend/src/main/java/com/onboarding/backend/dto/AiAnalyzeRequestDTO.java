package com.onboarding.kyc.web.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ApiAiAssessmentRequest {
    private ApiCddInfoRequest submittedData;
    private ApiComparisonResponse.ExternalData companiesHouse;
    private ApiComparisonResponse.ExternalData customerSystem;
}