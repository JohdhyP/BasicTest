package com.project.test.accenture.testBasic_v1.payload.response;


import com.project.test.accenture.testBasic_v1.model.User;
import com.project.test.accenture.testBasic_v1.model.UserSetting;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class UserPostResponse {
private User user_data;
private List<Map.Entry<String,String>> user_settings;
}
