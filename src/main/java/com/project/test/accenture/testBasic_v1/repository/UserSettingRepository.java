package com.project.test.accenture.testBasic_v1.repository;

import com.project.test.accenture.testBasic_v1.model.UserSetting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserSettingRepository extends JpaRepository<UserSetting, Long> {

}
