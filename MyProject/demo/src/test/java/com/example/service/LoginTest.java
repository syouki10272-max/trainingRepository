package com.example.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LoginTest {

    private static class StubLogin implements Login {
        @Override
        public boolean authenticate(String userId, String password) {
            return "admin".equals(userId) && "secret".equals(password);
        }
    }

    @Test
    void authenticate_validCredentials_returnsTrue() {
        Login login = new StubLogin();
        assertTrue(login.authenticate("admin", "secret"),
                "認証が正しい資格情報で true を返すこと");
    }

    @Test
    void authenticate_invalidUserId_returnsFalse() {
        Login login = new StubLogin();
        assertFalse(login.authenticate("user", "secret"),
                "無効な userId では false を返すこと");
    }

    @Test
    void authenticate_invalidPassword_returnsFalse() {
        Login login = new StubLogin();
        assertFalse(login.authenticate("admin", "wrong"),
                "無効な password では false を返すこと");
    }

    @Test
    void authenticate_nullCredentials_returnsFalse() {
        Login login = new StubLogin();
        assertFalse(login.authenticate(null, null),
                "null の資格情報では false を返すこと");
    }
}