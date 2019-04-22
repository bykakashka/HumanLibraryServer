package com.byka.humanlibrary.converter.impl;

import com.byka.humanlibrary.converter.UserConverter;
import com.byka.humanlibrary.data.UserData;
import com.byka.humanlibrary.entity.User;
import com.byka.humanlibrary.entity.UserAuth;
import com.byka.humanlibrary.entity.UserRole;
import com.byka.humanlibrary.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DefaultUserConverter extends DefaultAbstractConverter<UserAuth, UserData> implements UserConverter {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserData convert(UserAuth userAuth) {
        UserData userData = new UserData();

        Long userId = userAuth.getUserId();
        fillUserInfo(userRepository.findById(userId), userData);
        userData.setNickname(userAuth.getNickname());
        setRoles(userAuth, userData);

        return userData;
    }

    private void setRoles(UserAuth userAuth, UserData userData) {
        List<UserRole> userRoles = userAuth.getRoles();

        List<String> roles = new ArrayList<>();
        if (userRoles != null) {
            userRoles.forEach(role ->
                roles.add(role.getRole())
            );
        }
        userData.setRoles(roles);
    }

    private void fillUserInfo(Optional<User> userOptional, UserData userData) {
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            userData.setAge(user.getAge());
            userData.setGender(user.getGender());
            userData.setName(user.getName());
            userData.setAge(user.getAge());
        }

    }
}
