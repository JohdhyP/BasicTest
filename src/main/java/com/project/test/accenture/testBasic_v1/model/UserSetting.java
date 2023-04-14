package com.project.test.accenture.testBasic_v1.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "UserSetting")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserSetting {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Size(min = 3, max = 100)
    @Column(name = "keys", nullable = false)
    private String key;
    @Size(min = 3, max = 100)
    @Column(name = "value1", nullable = false)
    private String value;

    @Column(name = "user_id")
    private Long user_id;
}
