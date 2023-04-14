package com.project.test.accenture.testBasic_v1.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
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

    @Column(nullable = false)
    @Size(min = 16, max = 16)
    private String ssn;

    @Column(nullable = false)
    @Size(min = 3, max = 100)
    private String firts_name;
    private String middle_name;

    @Column(nullable = false)
    @Size(min = 3, max = 100)
    private String family_name;

    private Date birth_date;

    @Column(nullable = false)
    private LocalDateTime created_time;

    @Column(nullable = false)
    private LocalDateTime updated_time;

    @Column(nullable = false)
    @Size(max = 100)
    private String created_by;

    @Column(nullable = false)
    @Size(max = 100)
    private String updated_by;

    private Boolean is_active;

    private LocalDateTime deleted_time;

}
