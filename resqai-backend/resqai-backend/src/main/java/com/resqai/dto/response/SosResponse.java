
package com.resqai.dto.response;

import lombok.*;

        import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SosResponse {

    private Long id;

    private Double latitude;

    private Double longitude;

    private String status;

    private LocalDateTime createdAt;
}