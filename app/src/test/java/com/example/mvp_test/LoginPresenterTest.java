package com.example.mvp_test;

import com.example.mvp_test.fragments.login.LoginModel;
import com.example.mvp_test.fragments.login.LoginPresenter;
import com.example.mvp_test.fragments.login.LoginPresenterImpl;
import com.example.mvp_test.fragments.login.LoginView;

import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.anyString;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class LoginPresenterTest extends TestCase {
    @Mock
    private LoginView view;
    @Mock
    private LoginModel model;

    private LoginPresenter loginPresenter;
    
    @Before
    public void setup() {
        view = Mockito.mock(LoginView.class);
        model = Mockito.mock(LoginModel.class);
        loginPresenter = new LoginPresenterImpl(model);
        loginPresenter.bind(view);
    }

    @Test
    public void test_login_successfully() {
        when(model.getPassword(anyString())).thenReturn("solunar");
        loginPresenter.verifyAccount(anyString(), "solunar");

        Mockito.verify(view, Mockito.times(1)).doLogin();
    }

    @Test
    public void test_login_failed() {
        when(model.getPassword(anyString())).thenReturn("solunar");
        loginPresenter.verifyAccount(anyString(), "wrong password");

        Mockito.verify(view, Mockito.times(1)).doShowMessage(anyString());
    }
}
