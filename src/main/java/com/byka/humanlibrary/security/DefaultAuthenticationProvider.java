package com.byka.humanlibrary.security;

import com.byka.humanlibrary.entity.User;
import com.byka.humanlibrary.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DefaultAuthenticationProvider implements AuthenticationProvider {
    @Autowired
    private UserService userService;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String nickname = authentication.getName();
        String password = authentication.getCredentials().toString();

        final User user = userService.findByNickname(nickname);

        if (user != null && passwordEncoder.matches(password, user.getPass())) {
            List<GrantedAuthority> authorities = new ArrayList<>();
            if (user.getRoles() != null) {
                user.getRoles().forEach(role ->
                    authorities.add(new SimpleGrantedAuthority(role))
                );
            }
            return new UsernamePasswordAuthenticationToken(nickname, password, authorities); // TODO encode here?
        } else {
            return null;
        }
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
