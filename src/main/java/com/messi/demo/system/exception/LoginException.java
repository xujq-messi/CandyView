package com.messi.demo.system.exception;

import com.messi.demo.core.exception.BusinesseException;

public class LoginException extends BusinesseException {
    public LoginException() {
        super("登陆失败");
    }
}
