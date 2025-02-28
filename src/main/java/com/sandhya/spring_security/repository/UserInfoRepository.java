package com.sandhya.spring_security.repository;

import com.sandhya.spring_security.domain.entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserInfoRepository extends JpaRepository<UserInfo, UUID> {

    UserInfo findByUserName(String username);

}
