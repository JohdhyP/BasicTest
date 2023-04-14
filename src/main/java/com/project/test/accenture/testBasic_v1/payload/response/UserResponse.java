package com.project.test.accenture.testBasic_v1.payload.response;

import com.project.test.accenture.testBasic_v1.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class UserResponse {

    private List<User> user;
    private int max_records;
    private int offset;

}
