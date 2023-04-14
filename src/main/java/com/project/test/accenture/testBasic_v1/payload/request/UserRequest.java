package com.project.test.accenture.testBasic_v1.payload.request;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserRequest {

    private String ssn;
    private String firts_name;
    private String last_name;
    private Date birth_date;

}
