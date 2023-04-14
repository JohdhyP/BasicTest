package com.project.test.accenture.testBasic_v1.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;
import java.util.Date;

@Data
@Entity
@Table(name = "Users")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "ssn")
    private String ssn;

    @Column(name = "firts_name")
    private String firts_name;

    @Column(name = "middle_name")
    private String middle_name;

    @Column(name = "family_name")
    private String family_name;

    @Column(name = "birth_date")
    private Date birth_date;

    @Column(name = "created_time")
    private LocalDateTime created_time;

    @Column(name = "updated_time")
    private LocalDateTime updated_time;

    @Column(name = "created_by")
    private String created_by;

    @Column(name = "updated_by")
    private String updated_by;

    @Column(name = "is_active")
    private Boolean is_active;

    @Column(name = "deleted_time")
    private LocalDateTime deleted_time;

}
