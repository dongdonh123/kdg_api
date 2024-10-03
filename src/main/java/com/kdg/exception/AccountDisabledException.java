package com.kdg.exception;

import org.springframework.security.core.AuthenticationException;

public class AccountDisabledException extends AuthenticationException {
    public AccountDisabledException(String msg) {
        super(msg);
    }
}
