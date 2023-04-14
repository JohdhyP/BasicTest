package com.project.test.accenture.testBasic_v1.payload.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserSettingRequest {
    private Long id;
    private String key;
    private String value;
    private Long user_id;
}
