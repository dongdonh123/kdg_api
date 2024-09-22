package com.kdg.config;

import org.springframework.security.core.AuthenticationException;

public class CustomUsernameNotFoundException extends AuthenticationException {
    public CustomUsernameNotFoundException(String msg) {
        super(msg);
    }
}
