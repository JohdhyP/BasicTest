package com.project.test.accenture.testBasic_v1.service.implementation;

import com.project.test.accenture.testBasic_v1.model.User;
import com.project.test.accenture.testBasic_v1.model.UserSetting;
import com.project.test.accenture.testBasic_v1.payload.request.UserRequest;
import com.project.test.accenture.testBasic_v1.payload.response.UserResponse;
import com.project.test.accenture.testBasic_v1.repository.UserRepository;
import com.project.test.accenture.testBasic_v1.repository.UserSettingRepository;
import com.project.test.accenture.testBasic_v1.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class UserImpl  implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserSettingRepository userSettingRepository;

    @Override
    public UserResponse getAll(int max_records, int offset) {
        try {
            List<User> all = userRepository.findAll();

            List<User> listAll = new ArrayList<>();

            for (User cek : all) {
                if(cek.getIs_active() == true) {
                    User response = new User();
                    response.setId(cek.getId());
                    response.setSsn(cek.getSsn());
                    response.setFirts_name(cek.getFirts_name());
                    response.setFamily_name(cek.getFamily_name());
                    response.setBirth_date(cek.getBirth_date());
                    response.setCreated_time(cek.getCreated_time());
                    response.setUpdated_time(cek.getUpdated_time());
                    response.setCreated_by(cek.getCreated_by());
                    response.setUpdated_by(cek.getUpdated_by());
                    response.setIs_active(cek.getIs_active());
                    response.setDeleted_time(cek.getDeleted_time());
                    listAll.add(response);
                }
            }
            UserResponse responseFinal = new UserResponse();
            responseFinal.setUser(listAll);
            responseFinal.setMax_records(max_records);
            responseFinal.setOffset(offset);

            return responseFinal;
        } catch (Exception e) {
            log.error(e.getMessage());
            return null;
        }
    }

    @Override
    public User getUserById(Long id) {
        try {
            return userRepository.findById(id).get();
        } catch (Exception e) {
            log.error(e.getMessage());
            return null;
        }
    }

    @Override
    public User CreateDataUser(UserRequest request) {
        try{
            LocalDateTime datetime = LocalDateTime.now();

            User userNew = new User();


            userNew.setSsn(request.getSsn());
            userNew.setFirts_name(request.getFirts_name());
            userNew.setFamily_name(request.getLast_name());
            userNew.setBirth_date(request.getBirth_date());
            userNew.setCreated_time(datetime);
            userNew.setUpdated_time(datetime);
            userNew.setCreated_by("SYSTEM");
            userNew.setSsn("SYSTEM");
            userNew.setIs_active(true);

            User user = userRepository.save(userNew);

            UserSetting uSetting = new UserSetting();
            uSetting.setUser_id(user.getId());
            uSetting.setKey("biometric_login");
            uSetting.setValue("false");

            userSettingRepository.save(uSetting);

            return userNew;

        }catch(Exception e){
            log.error(e.getMessage());
            return null;
        }
    }

    @Override
    public User putUser(UserRequest request, Long id) {
        try {
            User UpdateUser = userRepository.findById(id).get();

            UpdateUser.setSsn(request.getSsn());
            UpdateUser.setFirts_name(request.getFirts_name());
            UpdateUser.setFamily_name(request.getLast_name());
            UpdateUser.setBirth_date(request.getBirth_date());

            userRepository.save(UpdateUser);

            return UpdateUser;

        } catch (Exception e) {
            log.error(e.getMessage());
            return null;
        }
    }

    @Override
    public User deleteUser(Long id) {
        try {
            User UpdateDeleteUser = userRepository.findById(id).get();
            LocalDateTime datetime = LocalDateTime.now();

            UpdateDeleteUser.setIs_active(false);
            UpdateDeleteUser.setDeleted_time(datetime);

            userRepository.save(UpdateDeleteUser);

            return null;

        } catch (Exception e) {
            log.error(e.getMessage());
            return null;
        }
    }

    @Override
    public User putUserRefresh(Long id) {
        try {
            User UpdateUserRefresh = userRepository.findById(id).get();

            UpdateUserRefresh.setIs_active(true);
            UpdateUserRefresh.setDeleted_time(null);

            userRepository.save(UpdateUserRefresh);

            return UpdateUserRefresh;

        } catch (Exception e) {
            log.error(e.getMessage());
            return null;
        }
    }

}
