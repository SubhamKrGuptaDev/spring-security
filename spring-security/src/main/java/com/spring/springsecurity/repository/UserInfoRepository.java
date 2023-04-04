package com.spring.springsecurity.repository;

import com.spring.springsecurity.entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserInfoRepository extends JpaRepository<UserInfo, String> {

}
