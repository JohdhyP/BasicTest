package com.project.test.accenture.testBasic_v1.service;

import com.project.test.accenture.testBasic_v1.model.User;
import com.project.test.accenture.testBasic_v1.payload.request.UserRequest;
import com.project.test.accenture.testBasic_v1.payload.response.UserPostResponse;
import com.project.test.accenture.testBasic_v1.payload.response.UserResponse;

import java.util.List;
import java.util.Map;

public interface UserService {
;
    public UserResponse getAll(int max_records, int offset);

    public UserPostResponse getUserById(Long id);

    public UserPostResponse CreateDataUser(UserRequest request);

    public UserPostResponse putUser(UserRequest request, Long id);

    public UserPostResponse putUserSetting(List<Map<String, String>> userSettings, Long id);

    public User deleteUser(Long id);

    public UserPostResponse putUserRefresh(Long id);

}
