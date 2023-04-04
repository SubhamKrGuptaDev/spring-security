package com.spring.springsecurity.servie;

import com.spring.springsecurity.entity.UserInfo;
import com.spring.springsecurity.repository.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserInfoServiceImpl implements UserInfoService{

    @Autowired
    private UserInfoRepository repository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserInfo create(UserInfo user) {

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return repository.save(user);
    }

    @Override
    public List<UserInfo> getAll() {
        return repository.findAll();
    }

    @Override
    public UserInfo getSingle(String username) {
        return repository.findById(username)
                .orElseThrow(() -> new UsernameNotFoundException("User Name Not Found Exception"));
    }
}
