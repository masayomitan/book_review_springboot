package com.example.demo.service;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.webapp.certificationtest.mapper.RegisterMemberMapper;

@Service
@Transactional
public class RegisterMemberService {

    @Autowired
    RegisterMemberMapper registerMemberMapper;

    @Autowired
    PasswordEncoder passwordEncoder;

    /**
     * 会員情報をDBに登録。
     */
    public void registerMember(MemberRegistrationEntity entity) {

        //パスワードをハッシュ化して、insertMemberInfo()に渡すオブジェクトにセット。
        entity.setPassword(passwordEncoder.encode(entity.getPassword()));

        registMemberMapper.insertMemberInfo(entity);
    }
}