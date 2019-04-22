package com.byka.humanlibrary.service.impl;

import com.byka.humanlibrary.converter.UserConverter;
import com.byka.humanlibrary.data.UserData;
import com.byka.humanlibrary.entity.UserAuth;
import com.byka.humanlibrary.repository.UserAuthRepository;
import com.byka.humanlibrary.service.UserAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DefaultUserAuthService implements UserAuthService {
    @Autowired
    private UserAuthRepository userAuthRepository;

    @Autowired
    private UserConverter userConverter;

    @Override
    public Optional<UserAuth> findByNickname(String nickname) {
        return userAuthRepository.findById(nickname);
    }

    @Override
    public UserData getByNickname(final String nickname) {
        UserAuth userAuth = userAuthRepository.findById(nickname).orElse(null);
        if (userAuth != null) {
            return userConverter.convert(userAuth);
        }

        return null;
    }

    @Override
    public UserAuth getCurrent() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        final String nickname = auth.getPrincipal().toString();
        return findByNickname(nickname).orElse(null);
    }
}
