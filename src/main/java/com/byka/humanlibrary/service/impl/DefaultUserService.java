package com.byka.humanlibrary.service.impl;

import com.byka.humanlibrary.constants.UserRoleEnum;
import com.byka.humanlibrary.converter.UserConverter;
import com.byka.humanlibrary.data.BoardData;
import com.byka.humanlibrary.data.UserData;
import com.byka.humanlibrary.data.UserRegistrationData;
import com.byka.humanlibrary.entity.Board;
import com.byka.humanlibrary.entity.User;
import com.byka.humanlibrary.entity.UserRole;
import com.byka.humanlibrary.repository.UserRepository;
import com.byka.humanlibrary.service.BoardService;
import com.byka.humanlibrary.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class DefaultUserService implements UserService {
    private static final Logger LOG = LoggerFactory.getLogger(DefaultEventService.class);

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserConverter userConverter;

    @Autowired
    private BoardService boardService;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public User findByNickname(String nickname) {
        List<User> userList = userRepository.getByNickname(nickname);
        if (userList == null || userList.isEmpty()) {
            return null;
        }

        if (userList.size() != 1) {
            LOG.warn("Incorrect size of user list by nickname: " + nickname);
            return null;
        }

        return userList.get(0);
    }

    @Override
    public UserData getByNicknameOrAnon(final String nickname) {
        final User user = this.findByNickname(nickname);
        if (user != null) {
            return userConverter.convert(user);
        } else {
            return null; // TODO
        }
    }

    @Override
    public User getCurrent() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        final String nickname = auth.getPrincipal().toString();
        return findByNickname(nickname);
    }

    @Override
    public UserData createUser(UserRegistrationData data) {
        User user = new User();
        user.setNickname(data.getNickname());
        user.setPass(passwordEncoder.encode(data.getPass()));
        user.setRoles(Collections.singletonList("ROLE_" + UserRoleEnum.READER.name()));
        return userConverter.convert(userRepository.save(user));
    }
}
