package com.example.mvp_test.fragments.login;

import javax.inject.Inject;

public class LoginPresenterImpl implements LoginPresenter {

    private         LoginView   view;
    private final   LoginModel  model;

    @Inject
    public LoginPresenterImpl(LoginModel model) {
        this.model = model;
    }

    @Override
    public void bind(LoginView view) {
        this.view = view;
    }

    @Override
    public void unbind() {
        this.view = null;
    }

    @Override
    public void login() {
        view.doLogin();
    }

    @Override
    public void verifyAccount(String username, String password) {
        if (model.getPassword(username).equals(password)) {
            login();
        }
        else {
            view.doShowMessage("Account not valid");
        }
    }
}
