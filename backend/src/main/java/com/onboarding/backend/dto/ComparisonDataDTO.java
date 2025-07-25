package com.onboarding.kyc.web.dto;

import lombok.*;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ApiComparisonResponse {
    private ApiCddInfoRequest cddInfo;
    private ExternalData companiesHouse;
    private ExternalData customerSystem;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class ExternalData {
        private String fullLegalName;
        private String registeredNumber;
        private String registeredAddress;
        private String legalForm;
        private String countryOfEstablishment;
        private LocalDate dateOfIncorporation;
        private String tradingName;
    }
}