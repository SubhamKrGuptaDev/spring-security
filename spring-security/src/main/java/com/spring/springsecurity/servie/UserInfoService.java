package com.spring.springsecurity.servie;


import com.spring.springsecurity.entity.UserInfo;

import java.util.List;

public interface UserInfoService {
    UserInfo create(UserInfo user);

    List<UserInfo> getAll();

    UserInfo getSingle(String username);

}
