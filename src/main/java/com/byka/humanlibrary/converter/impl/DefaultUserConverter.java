package com.byka.humanlibrary.converter.impl;

import com.byka.humanlibrary.converter.UserConverter;
import com.byka.humanlibrary.data.UserData;
import com.byka.humanlibrary.entity.User;
import com.byka.humanlibrary.entity.UserInfo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DefaultUserConverter extends DefaultAbstractConverter<User, UserData> implements UserConverter {
    @Override
    public UserData convert(User user) {
        UserData userData = new UserData();

        fillUserInfo(user, userData);
        userData.setNickname(user.getNickname());
        setRoles(user, userData);

        return userData;
    }

    private void setRoles(User user, UserData userData) {
        List<String> userRoles = user.getRoles();

        List<String> roles = new ArrayList<>();
        if (userRoles != null) {
            roles.addAll(userRoles);
        }
        userData.setRoles(roles);
    }

    private void fillUserInfo(User user, UserData userData) {
        UserInfo userInfo = user.getUserInfo();
        if (userInfo != null) {
            userData.setAge(userInfo.getAge());
            userData.setGender(userInfo.getGender());
            userData.setName(userInfo.getName());
            userData.setAge(userInfo.getAge());
        }
    }
}
