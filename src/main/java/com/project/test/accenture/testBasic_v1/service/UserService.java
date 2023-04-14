package com.project.test.accenture.testBasic_v1.service;

import com.project.test.accenture.testBasic_v1.model.User;
import com.project.test.accenture.testBasic_v1.payload.request.UserRequest;
import com.project.test.accenture.testBasic_v1.payload.response.UserResponse;

import java.util.List;

public interface UserService {
;
    public UserResponse getAll(int max_records, int offset);

    public User getUserById(Long id);

    public User CreateDataUser(UserRequest request);

    public User putUser(UserRequest request, Long id);

    public User deleteUser(Long id);

    public User putUserRefresh(Long id);

}
