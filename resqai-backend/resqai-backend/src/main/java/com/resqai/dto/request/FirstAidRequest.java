

package com.resqai.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FirstAidRequest {

    @NotBlank
    private String emergencyType;

    @NotBlank
    private String symptoms;

    @NotBlank
    private String firstAidSteps;
}