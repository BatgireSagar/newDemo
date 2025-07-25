package com.onboarding.backend.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "ai_results")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AiResults {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String caseId;

    @Lob
    @Column(columnDefinition = "TEXT")
    private String conflicts; // JSON array

    @Lob
    @Column(columnDefinition = "TEXT")
    private String missingFields; // JSON array

    private String recommendation;
    private LocalDateTime createdAt;
}