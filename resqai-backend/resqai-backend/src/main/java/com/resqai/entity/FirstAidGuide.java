

package com.resqai.entity;

import jakarta.persistence.*;
        import lombok.*;

@Entity
@Table(name = "first_aid_guides")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FirstAidGuide {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String emergencyType;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String symptoms;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String firstAidSteps;
}