package com.byka.humanlibrary.service;

import com.byka.humanlibrary.data.UserData;
import com.byka.humanlibrary.data.UserRegistrationData;
import com.byka.humanlibrary.entity.User;


public interface UserService {
    User findByNickname(String nickname);

    UserData getByNicknameOrAnon(String nickname);

    User getCurrent();

    UserData createUser(UserRegistrationData data);
}
