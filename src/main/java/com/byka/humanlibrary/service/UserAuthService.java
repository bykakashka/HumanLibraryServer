package com.byka.humanlibrary.service;

import com.byka.humanlibrary.data.UserData;
import com.byka.humanlibrary.entity.User;
import com.byka.humanlibrary.entity.UserAuth;

import java.util.Optional;

public interface UserAuthService {
    Optional<UserAuth> findByNickname(String nickname);

    UserData getByNickname(String nickname);

    UserAuth getCurrent();
}
