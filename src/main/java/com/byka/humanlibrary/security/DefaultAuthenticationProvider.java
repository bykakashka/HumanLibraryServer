package com.byka.humanlibrary.security;

import com.byka.humanlibrary.entity.UserAuth;
import com.byka.humanlibrary.service.UserAuthService;
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
import java.util.Optional;

@Service
public class DefaultAuthenticationProvider implements AuthenticationProvider {
    @Autowired
    private UserAuthService userAuthService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String nickname = authentication.getName();
        String password = authentication.getCredentials().toString();
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        final Optional<UserAuth> userAuthOptional = userAuthService.findByNickname(nickname);

        if (userAuthOptional.isPresent() && encoder.matches(password, userAuthOptional.get().getPass())) {
            final UserAuth userAuth = userAuthOptional.get();
            List<GrantedAuthority> authorities = new ArrayList<>();
            if (userAuth.getRoles() != null) {
                userAuth.getRoles().forEach(role ->
                    authorities.add(new SimpleGrantedAuthority(role.getRole()))
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
