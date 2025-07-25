package com.onboarding.kyc.domain.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "case_journey")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OnboardingJourney {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String caseId;
    private String journeyStatus; // Fast Track, Standard, EDD
    private LocalDateTime lastUpdated;
}