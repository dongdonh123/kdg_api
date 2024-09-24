package com.kdg.config;

import org.springframework.security.core.AuthenticationException;

public class AccountLockedException extends RuntimeException  {
    public AccountLockedException(String message) {
        super(message);
    }
}
