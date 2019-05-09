package com.byka.humanlibrary.service.impl;

import com.byka.humanlibrary.converter.UserConverter;
import com.byka.humanlibrary.converter.impl.DefaultUserConverter;
import com.byka.humanlibrary.data.UserData;
import com.byka.humanlibrary.data.UserRegistrationData;
import com.byka.humanlibrary.entity.User;
import com.byka.humanlibrary.repository.UserRepository;
import com.byka.humanlibrary.repository.UserToBoardRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Collections;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class DefaultUserServiceTest {
    @InjectMocks
    private DefaultUserService classUnderTest;

    @Mock
    private UserRepository userRepository;

    @Mock
    private UserConverter userConverter;

    @Mock
    private BCryptPasswordEncoder passwordEncoder;

    @Test
    public void createUser() {
        User user = Mockito.mock(User.class);
        UserRegistrationData data = new UserRegistrationData();
        data.setPass("pass");

        Mockito.when(userRepository.save(Mockito.any(User.class))).thenReturn(user);
        classUnderTest.createUser(data);

        ArgumentCaptor<User> argument = ArgumentCaptor.forClass(User.class);
        Mockito.verify(userRepository, Mockito.times(1)).save(argument.capture());
        assertEquals(Collections.singletonList("ROLE_READER"), argument.getValue().getRoles());
        Mockito.verify(userRepository, Mockito.times(1)).save(Mockito.any(User.class));
        Mockito.verify(passwordEncoder, Mockito.times(1)).encode("pass");
        Mockito.verify(userConverter, Mockito.times(1)).convert(user);
    }
}
