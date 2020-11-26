package com.example.mvp_test;

import com.example.mvp_test.fragments.login.LoginModel;
import com.example.mvp_test.fragments.login.LoginModelImpl;

import junit.framework.TestCase;

import org.junit.Test;

public class LoginModelTest extends TestCase {
    private final LoginModel model = new LoginModelImpl();

    @Test
    public void test_isAccountValid_1() {
        String username = "tim";
        assertEquals(model.getPassword(username), "solunar");
    }

    @Test
    public void test_isAccountValid_2() {
        String username = "timmmmmm";
        assertNotSame(model.getPassword(username), "solunar");
    }
}
