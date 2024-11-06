package com.kdg.exception;

import org.springframework.security.core.AuthenticationException;

public class PasswordNullException extends AuthenticationException {
    public PasswordNullException(String msg) {
        super(msg);
    }
}