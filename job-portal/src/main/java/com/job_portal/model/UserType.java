package com.job_portal.model;

import jakarta.persistence.*;
import lombok.Data;

@Table(name = "users_type")
@Entity
@Data
public class UserType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_type_id")
    private Integer userTypeId;

    @Column(name = "user_type_name")
    private String userTypeName;


}
