
package com.resqai.dto.response;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FirstAidResponse {

    private Long id;

    private String emergencyType;

    private String symptoms;

    private String firstAidSteps;
}