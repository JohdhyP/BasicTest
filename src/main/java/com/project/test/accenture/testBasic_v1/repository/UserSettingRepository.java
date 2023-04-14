package com.project.test.accenture.testBasic_v1.repository;

import com.project.test.accenture.testBasic_v1.model.UserSetting;
import com.project.test.accenture.testBasic_v1.payload.response.UserSettingResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface UserSettingRepository extends JpaRepository<UserSetting, Long> {
//    List<UserSetting> getByUserId(Long id);
    @Query("select new com.project.test.accenture.testBasic_v1.payload.response.UserSettingResponse(m.id, m.key, m.value, m.user_id) from UserSetting m WHERE m.user_id = ?1 ")
    List<UserSettingResponse> findByIdUser(Long id);

}
