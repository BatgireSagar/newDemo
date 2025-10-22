package com.onboarding.backend.controller;

import com.onboarding.backend.dto.*;
import com.onboarding.backend.model.*;
import com.onboarding.backend.service.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class OnboardingController {
    private final ClientInfoService clientInfoService;
    private final CompaniesHouseDataService companiesHouseDataService;
    private final CustomerSystemDataService customerSystemDataService;
    private final AiResultsService aiResultsService;
    private final CaseJourneyService caseJourneyService;
    private final BedrockAiService bedrockAiService;

    @Operation(summary = "Capture CDD data", responses = {
            @ApiResponse(responseCode = "200", description = "CDD data captured")
    })
    @PostMapping("/client/capture")
    public ResponseEntity<ClientInfoDTO> captureClient(@RequestBody ClientInfoDTO dto) {
        ClientInfo entity = ClientInfo.builder()
                .caseId(dto.getCaseId())
                .registrationNo(dto.getRegistrationNo())
                .clientName(dto.getClientName())
                .country(dto.getCountry())
                .sla(dto.getSla())
                .assignedTo(dto.getAssignedTo())
                .fastTrackStatus(dto.getFastTrackStatus())
                .fullLegalName(dto.getFullLegalName())
                .registeredNumber(dto.getRegisteredNumber())
                .registeredAddress(dto.getRegisteredAddress())
                .legalForm(dto.getLegalForm())
                .countryOfEstablishment(dto.getCountryOfEstablishment())
                .dateOfIncorporation(dto.getDateOfIncorporation())
                .tradingName(dto.getTradingName())
                .build();
        clientInfoService.save(entity);
        return ResponseEntity.ok(dto);
    }

    @Operation(summary = "Fetch comparison data", responses = {
            @ApiResponse(responseCode = "200", description = "Comparison data fetched")
    })
    @GetMapping("/data/compare/{caseId}")
    public ResponseEntity<ComparisonDataDTO> compareData(@PathVariable String caseId) {
        Optional<ClientInfo> cdd = clientInfoService.findByCaseId(caseId);
        Optional<CompaniesHouseData> ch = companiesHouseDataService.findByCaseId(caseId);
        Optional<CustomerSystemData> cs = customerSystemDataService.findByCaseId(caseId);
        ComparisonDataDTO dto = ComparisonDataDTO.builder()
                .cddInfo(cdd.map(this::toClientInfoDTO).orElse(null))
                .companiesHouse(ch.map(this::toExternalData).orElse(null))
                .customerSystem(cs.map(this::toExternalData).orElse(null))
                .build();
        return ResponseEntity.ok(dto);
    }

    @Operation(summary = "Run AI analysis", responses = {
            @ApiResponse(responseCode = "200", description = "AI analysis result")
    })
    @PostMapping("/ai/analyze")
    public ResponseEntity<AiAnalyzeResponseDTO> analyze(@RequestBody AiAnalyzeRequestDTO request) {
        AiAnalyzeResponseDTO result = bedrockAiService.analyze(request);
        // Save result
        AiResults aiResults = AiResults.builder()
                .caseId(request.getSubmittedData().getCaseId())
                .conflicts(result.getConflicts().toString())
                .missingFields(result.getMissingFields().toString())
                .recommendation(result.getRecommendation())
                .createdAt(LocalDateTime.now())
                .build();
        aiResultsService.save(aiResults);
        return ResponseEntity.ok(result);
    }

    @Operation(summary = "Contact client for clarification", responses = {
            @ApiResponse(responseCode = "200", description = "Contact simulated")
    })
    @PostMapping("/contact-client/{caseId}")
    public ResponseEntity<String> contactClient(@PathVariable String caseId) {
        // Simulate sending a message/email
        return ResponseEntity.ok("Contacted client for case " + caseId);
    }

    @Operation(summary = "Get onboarding journey decision", responses = {
            @ApiResponse(responseCode = "200", description = "Journey decision returned")
    })
    @GetMapping("/journey/decision/{caseId}")
    public ResponseEntity<CaseJourneyDTO> getJourneyDecision(@PathVariable String caseId) {
        Optional<AiResults> ai = aiResultsService.findByCaseId(caseId);
        String recommendation = ai.map(AiResults::getRecommendation).orElse("Standard");
        CaseJourney journey = CaseJourney.builder()
                .caseId(caseId)
                .journeyStatus(recommendation)
                .lastUpdated(LocalDateTime.now())
                .build();
        caseJourneyService.save(journey);
        CaseJourneyDTO dto = CaseJourneyDTO.builder()
                .caseId(caseId)
                .journeyStatus(recommendation)
                .lastUpdated(journey.getLastUpdated())
                .build();
        return ResponseEntity.ok(dto);
    }

    // --- Helper mappers ---
    private ClientInfoDTO toClientInfoDTO(ClientInfo c) {
        return ClientInfoDTO.builder()
                .caseId(c.getCaseId())
                .registrationNo(c.getRegistrationNo())
                .clientName(c.getClientName())
                .country(c.getCountry())
                .sla(c.getSla())
                .assignedTo(c.getAssignedTo())
                .fastTrackStatus(c.getFastTrackStatus())
                .fullLegalName(c.getFullLegalName())
                .registeredNumber(c.getRegisteredNumber())
                .registeredAddress(c.getRegisteredAddress())
                .legalForm(c.getLegalForm())
                .countryOfEstablishment(c.getCountryOfEstablishment())
                .dateOfIncorporation(c.getDateOfIncorporation())
                .tradingName(c.getTradingName())
                .build();
    }
    private ComparisonDataDTO.ExternalData toExternalData(CompaniesHouseData d) {
        return ComparisonDataDTO.ExternalData.builder()
                .fullLegalName(d.getFullLegalName())
                .registeredNumber(d.getRegisteredNumber())
                .registeredAddress(d.getRegisteredAddress())
                .legalForm(d.getLegalForm())
                .countryOfEstablishment(d.getCountryOfEstablishment())
                .dateOfIncorporation(d.getDateOfIncorporation())
                .tradingName(d.getTradingName())
                .build();
    }
    private ComparisonDataDTO.ExternalData toExternalData(CustomerSystemData d) {
        return ComparisonDataDTO.ExternalData.builder()
                .fullLegalName(d.getFullLegalName())
                .registeredNumber(d.getRegisteredNumber())
                .registeredAddress(d.getRegisteredAddress())
                .legalForm(d.getLegalForm())
                .countryOfEstablishment(d.getCountryOfEstablishment())
                .dateOfIncorporation(d.getDateOfIncorporation())
                .tradingName(d.getTradingName())
                .build();
    }
}