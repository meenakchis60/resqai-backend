
package com.resqai.dto.response;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmergencyContactResponse {

    private Long id;

    private String name;

    private String relationship;

    private String phoneNumber;

    private Integer priority;
}