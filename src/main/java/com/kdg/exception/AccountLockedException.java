package com.kdg.exception;

import org.springframework.security.core.AuthenticationException;

public class AccountLockedException extends AuthenticationException {
    public AccountLockedException(String msg) {
        super(msg);
    }
}