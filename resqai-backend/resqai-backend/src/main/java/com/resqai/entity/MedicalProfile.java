
package com.resqai.entity;

import jakarta.persistence.*;
        import lombok.*;

@Entity
@Table(name = "medical_profiles")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MedicalProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String bloodGroup;

    @Column(length = 500)
    private String allergies;

    @Column(length = 500)
    private String medicalConditions;

    @Column(length = 500)
    private String medications;

    @Column(length = 1000)
    private String emergencyNotes;

    @OneToOne
    @JoinColumn(name = "user_id", nullable = false, unique = true)
    private User user;
}