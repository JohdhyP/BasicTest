package com.project.test.accenture.testBasic_v1;

import com.project.test.accenture.testBasic_v1.model.User;
import com.project.test.accenture.testBasic_v1.repository.UserRepository;
import lombok.Data;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@DataJpaTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class UserRepositoryTests {

    @Autowired
    private UserRepository userRepository;

    @Test
    @Order(1)
    @Rollback(value = false)
    public void saveEmployeeTest(){
        Date date = new Date();
        LocalDateTime datetime = LocalDateTime.now();
        User user = User.builder()
                .ssn("aklsdjaksldjklasd")
                .firts_name("Fadatare")
                .family_name("ramesh@gmail.com")
                .birth_date(date)
                .created_time(datetime)
                .updated_time(datetime)
                .created_by("SYSTEM")
                .updated_by("SYSTEM")
                .is_active(true)
                .build();

        userRepository.save(user);

        Assertions.assertThat(user.getId()).isGreaterThan(0);
    }

    @Test
    @Order(2)
    public void getUserTest(){

        User user = userRepository.findById(1L).get();

        Assertions.assertThat(user.getId()).isEqualTo(1L);

    }

    @Test
    @Order(3)
    public void getListOfUserTest(){

        List<User> user = userRepository.findAll();

        Assertions.assertThat(user.size()).isGreaterThan(0);

    }

    @Test
    @Order(4)
    @Rollback(value = false)
    public void updateUserTest(){

        User user = userRepository.findById(1L).get();

        user.setSsn("tesaja");

        User userUdpate =  userRepository.save(user);

        Assertions.assertThat(userUdpate.getSsn()).isEqualTo("tesaja");

    }

    @Test
    @Order(5)
    @Rollback(value = false)
    public void deleteUserTest(){

        User user = userRepository.findById(1L).get();

        userRepository.delete(user);

        User user1 = null;

        Optional<User> optionalUser = userRepository.findById(1L);

        if(optionalUser.isPresent()){
            user1 = optionalUser.get();
        }

        Assertions.assertThat(user1).isNull();
    }
}
