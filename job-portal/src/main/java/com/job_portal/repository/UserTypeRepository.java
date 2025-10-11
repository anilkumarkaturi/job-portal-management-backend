package com.job_portal.repository;

import com.job_portal.model.UserType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserTypeRepository extends JpaRepository<UserType, Integer> {
    List<UserType> findAllByUserTypeName(String userTypeName);
}