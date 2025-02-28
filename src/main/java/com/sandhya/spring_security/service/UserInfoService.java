package com.sandhya.spring_security.service;

import com.sandhya.spring_security.domain.UserDetailsInfo;
import com.sandhya.spring_security.domain.entity.UserInfo;
import com.sandhya.spring_security.repository.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserInfoService implements UserDetailsService {

    @Autowired
    private UserInfoRepository userInfoRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserInfo userInfo = userInfoRepository.findByUserName(username);
        return UserDetailsInfo.builder()
                .userName(username)
                .password(userInfo.getPassword())
                .roles(userInfo.getRoles())
                .build();
    }

    public UserInfo createUser(UserInfo userInfo) {
        userInfo.setPassword(passwordEncoder.encode(userInfo.getPassword()));
        return userInfoRepository.save(userInfo);
    }
}
